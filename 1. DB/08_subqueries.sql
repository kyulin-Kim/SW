-- employee 과제 db(employeedb)에서 실행해 볼 것
-- 유재식씨의 부서와 같은 부서에서 일하는 직원
SELECT * FROM employee;

-- 서브쿼리
SELECT dept_code FROM employee WHERE emp_name = '유재식'; -- D6

-- 메인쿼리
SELECT * FROM employee WHERE dept_code = 'D6';	-- 유재식씨와 같은 부서에서 일하는 직원(본인 포함)

-- 서브쿼리를 포함한 메인쿼리
SELECT
       *
  FROM employee
 WHERE dept_code = (SELECT dept_code
                      FROM employee
                     WHERE emp_name = '유재식');
                     
-- 이와 같은 방법으로 유재식씨 사원번호를 추출해서 해당 사원을 제거해 보자.
SELECT
       *
  FROM employee
 WHERE dept_code = (SELECT dept_code
                      FROM employee
                     WHERE emp_name = '유재식')
   AND emp_id <> (SELECT emp_id
                    FROM employee
                   WHERE emp_name = '유재식');
-- ----------------------------------
-- 상관 서브쿼리                  
-- 메뉴 조회 시 메뉴의 카테고리에 있는 메뉴들의 평균 가격보다 높은 메뉴만 조회
-- (상관서브쿼리, 단일행 서브쿼리)
SELECT
       a.menu_code
     , a.menu_name
     , a.menu_price
     , a.category_code
     , a.orderable_status
  FROM tbl_menu a
 WHERE a.menu_price > (SELECT AVG(b.menu_price)
                         FROM tbl_menu b
                        WHERE b.category_code = a.category_code);

-- 메뉴 카테고리의 평균과 같은 가격의 메뉴를 조회(상관 서브쿼리 안쓰고 다중행 서브쿼리)                        
SELECT
       *
  FROM tbl_menu a
 WHERE a.menu_price IN (SELECT AVG(b.menu_price)
                         FROM tbl_menu b
                        GROUP BY b.category_code);
                     
-- -------------------------------------------------------------
-- 메뉴가 있는 카테고리 조회
SELECT
       category_code
     , category_name
  FROM tbl_category a
 WHERE EXISTS(SELECT 1
                FROM tbl_menu b
               WHERE b.category_code = a.category_code)
 ORDER BY 1;
-- ---------------------------------------------------------
-- 4번 카테고리를 메인 쿼리에서 where조건 판별 중 동작하는 서브쿼리
SELECT 1
  FROM tbl_menu b
 WHERE b.category_code = 4;
 
-- -------------------------------------------------------------
-- join을 활용한 메뉴가 있는 카테고리 조회도 해보자.
SELECT
       a.category_code
     , a.category_name
  FROM tbl_category a
  JOIN tbl_menu b ON (a.category_code = b.category_code)
 GROUP BY a.category_code, a.category_name
 ORDER BY 1;
 
-- -----------------------------------------------------
-- employee 과제 db(employeedb)에서 실행해 볼 것
-- 1. 가장 높은 급여를 받는 사원 조회하기(MAX(컬럼명))
-- 서브쿼리
SELECT
       MAX(salary)
  FROM employee;

SELECT
       *
  FROM employee
 WHERE salary = (SELECT MAX(salary)
                   FROM employee);
                                   

-- 2. 평균 급여가 가장 높은 부서 조회하기
--   (AVG(컬럼명), >= ALL)

-- i) 이중 서브 쿼리를 활용한 방법
SELECT AVG(salary)
  FROM employee
 GROUP BY dept_code;
 
SELECT MAX(a.sal_avg)
  FROM (SELECT AVG(salary) sal_avg
          FROM employee
         GROUP BY dept_code) a;

SELECT
       a.dept_code
     , b.dept_title
  FROM employee a
  JOIN department b ON (b.dept_id = a.dept_code)
 GROUP BY a.dept_code
HAVING AVG(a.salary) = (SELECT max(c.sal_avg)
                        FROM (SELECT AVG(salary) sal_avg
                                FROM employee
                               GROUP BY dept_code) c);
                               
-- ii) >= ALL을 활용한 방법
-- 서브쿼리 중에 다중행 서브쿼리인 경우에는 비교 연산자가 일반 비교연산자와 달라진다.
-- > ALL, < ALL, > ANY, < ANY, IN
-- 1. > ALL: 모든 서브쿼리 결과보다 크다(서브쿼리의 최대값보다 크다)
-- 2. < ALL: 모든 서브쿼리 결과보다 작다(서브쿼리의 최소값보다 작다)
-- 3. > ANY: 서브쿼리 결과 보다 최소 하나보다는 크다(서브쿼리의 최소값보다 크다)
-- 4. < ANY: 서브쿼리 결과 보다 최대 하나보다는 작다(서브쿼리의 최대값보다 작다)
-- 5. IN: 서브쿼리 결과 중에 하나라도 일치한다.
SELECT
       dept_code
  FROM employee
 GROUP BY dept_code
HAVING AVG(salary) >= ALL (SELECT AVG(salary)
                             FROM employee
                            GROUP BY dept_code);
 


                     
                     
                     
