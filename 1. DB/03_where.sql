SELECT
		  menu_name
		, menu_price
		, orderable_status
  FROM tbl_menu
 WHERE orderable_status = 'Y';
 
-- orderable_status = 'N'인 행들 조회하기
SELECT
		  menu_name
		, menu_code
		, orderable_status
  FROM tbl_menu
 WHERE orderable_status = 'N';

-- DESC를 통해 컬럼명 빠르게 확인 
DESC tbl_menu;

-- -------------------------------------------
-- '기타' 카테고리에 해당하지 않는 메뉴를 조회하시오.
-- 1) '기타' 카테고리의 번호 파악하기
SELECT * FROM tbl_category;
SELECT * FROM tbl_category WHERE category_name = '기타'; -- category_code가 '10번'임을 알아냄

-- 2) 해당 번호를 가지지 않는 메뉴 조회
-- SELECT * FROM tbl_menu;
SELECT * FROM tbl_menu WHERE category_code = 10;
SELECT * FROM tbl_menu WHERE category_code <> 10; -- != or <>으로 부정문 표현 가능

-- --------------------------------------------
-- 10,000원 이상의 메뉴 조회
SELECT * FROM tbl_menu WHERE menu_price >= 10000;

-- 10,000원 미만의 메뉴 조회
SELECT * FROM tbl_menu WHERE menu_price < 10000;

-- 10,000원 이상 12,000원 이하 메뉴 조회
SELECT
 		 * 
  FROM tbl_menu
 WHERE menu_price >= 10000
   AND menu_price <= 12000; -- && 으로 and 표현은 가능
   
-- --------------------------------------------
SELECT
		  menu_code
		, menu_name
		, menu_price
		, category_code
		, orderable_status
  FROM  tbl_menu
 WHERE  menu_price > 5000
	 OR  category_code = 10;
	
SELECT
		  menu_code
		, menu_name
		, menu_price
		, category_code
		, orderable_status
  FROM  tbl_menu
 WHERE  menu_price > 5000
	AND  category_code = 10;
	
-- -------------------------------
-- between 연산자 활용하기
-- 가격이 5000원 이상 9000 이하인 메뉴 전체 컬럼 조회
SELECT
		  *
	FROM tbl_menu
  WHERE menu_price >= 5000
  	 AND menu_price <= 9000;
		
SELECT
		  *
	FROM tbl_menu
  WHERE menu_price BETWEEN 5000 AND 9000;
  
-- -------------------------------
-- 반대 범위도 테스트하자
SELECT
		  *
	FROM tbl_menu
  WHERE menu_price < 5000
     OR menu_price > 9000;   

SELECT
		  *
	FROM tbl_menu
  WHERE menu_price NOT BETWEEN 5000 AND 9000;
  
-- -------------------------------------
-- like
-- 메뉴 이름에 '밥'이 들어가는 메뉴 조회하기
SELECT
		  *
	FROM tbl_menu
  WHERE menu_name LIKE '%밥%';
  
-- 메뉴 이름에 '밥'이 들어가지 않는 메뉴 조회하기
SELECT
       *
  FROM tbl_menu
--  WHERE menu_name NOT LIKE '%밥%';
 WHERE NOT menu_name LIKE '%밥%';

-- ---------------------------------------------------
-- in연산자

SELECT * FROM tbl_category;

-- or을 활용한 '중식', '커피', '기타' 카테고리의 메뉴 조회하기
SELECT
       *
  FROM tbl_menu
 WHERE category_code = 5
    OR category_code = 8
    OR category_code = 10;
    
-- in 연산자 활용
SELECT
       *
  FROM tbl_menu
 WHERE category_code IN (5, 8, 10);
 
-- -------------------------------------------------------
-- is null 연산자 활용

SELECT * FROM tbl_category;

-- ref_category_code(상위 카테고리 번호)가 없는 카테고리 조회
SELECT
       *
  FROM tbl_category
 WHERE ref_category_code IS NULL;

-- 반대도 해보자.
SELECT
       *
  FROM tbl_category
 WHERE ref_category_code IS NOT NULL;
  
SELECT
       *
  FROM tbl_category
 WHERE NOT ref_category_code IS NULL;
  
  
  
  
  
