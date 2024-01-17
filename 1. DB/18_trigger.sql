-- 메뉴 추가 시 update 자동화 trigger 만들기
DELIMITER //

CREATE OR REPLACE TRIGGER after_order_menu_insert
    AFTER INSERT
    ON tbl_order_menu
    FOR EACH ROW
BEGIN
    UPDATE tbl_order
    SET total_order_price = total_order_price + NEW.order_amount * (SELECT menu_price FROM tbl_menu WHERE menu_code = NEW.menu_code)
    WHERE order_code = NEW.order_code;
END//      

DELIMITER ;


-- 주문 테이블(tbl_order)에 insert 후 주문 메뉴 테이블(tbl_order_menu)에 주문한 메뉴마다
-- insert 후 주문 테이블에 총 금액이 업데이트 되는지 확인하자.
-- 주문 테이블 INSERT
INSERT
  INTO tbl_order
(
  order_code
, order_date
, order_time
, total_order_price
)
VALUES
(
  NULL
, CONCAT(CAST(YEAR(NOW()) AS VARCHAR(4))
	    , CAST(LPAD(MONTH(NOW()), 2, 0) AS VARCHAR(2))
	    , CAST(LPAD(DAY(NOW()), 2, 0) AS VARCHAR(2)))
, CONCAT(CAST(LPAD(HOUR(NOW()), 2, 0) AS VARCHAR(2))
       , CAST(LPAD(MINUTE(NOW()), 2, 0) AS VARCHAR(2))
       , CAST(LPAD(SECOND(NOW()), 2, 0) AS VARCHAR(2)))
, 0			
);

SELECT * FROM tbl_order;

-- 주문 메뉴 테이블 INSERT 1
INSERT
  INTO tbl_order_menu
(
  order_code
, menu_code
, order_amount
)
VALUES
(
  1
, 3
, 2
);

SELECT * FROM tbl_order_menu;

-- 주문 메뉴 테이블 INSERT 2
INSERT
  INTO tbl_order_menu
(
  order_code
, menu_code
, order_amount
)
VALUES
(
  1
, 6
, 3
);

SELECT * FROM tbl_order;
SELECT * FROM tbl_order_menu;

-- 다시 되돌려 테스트 해보고자 할 경우
-- 1) rollback하기
ROLLBACK;
-- 2) 기존 데이터 지우기
DELETE FROM tbl_order WHERE 1 = 1;
DELETE FROM tbl_order_menu WHERE 1 = 1;

-- 이후 AUTO_INCREMENT도 다시 초기화 해 준다.
ALTER TABLE tbl_order AUTO_INCREMENT = 1;


-- ------------------------------------------------------------
-- 상품 입출과 관련 trigger 활용 예제
DROP TABLE pro_detail;
DROP TABLE product;


CREATE TABLE PRODUCT(           -- 이력 테이블(UPDATE가 발생하는 테이블)
  PCODE INT PRIMARY KEY auto_increment,
  PNAME VARCHAR(30),
  BRAND VARCHAR(30),
  PRICE INT,
  STOCK INT DEFAULT 0,
  CHECK(STOCK >= 0)
);

CREATE TABLE PRO_DETAIL(        -- 내역 테이블(INSERT가 발생하는 테이블)
  DCODE INT PRIMARY KEY auto_increment,
  PCODE INT,
  PDATE DATE,
  AMOUNT INT,
  STATUS VARCHAR(10) CHECK(STATUS IN ('입고', '출고')),
  FOREIGN KEY(PCODE) REFERENCES PRODUCT  -- 어차피 해당 테이블의 PK컬럼에 대한 외래키이므로 PK컬럼은 적지 않아도 된다.(알아서 인식함)
);

INSERT
  INTO PRODUCT
(
  PCODE, PNAME, BRAND
, PRICE, STOCK
)
VALUES
(
  null, '갤럭시플립', '삼송'
, 900000, 5
);

INSERT
  INTO PRODUCT
(
  PCODE, PNAME, BRAND
, PRICE, STOCK
)
VALUES
(
  null, '아이펀 14', '애펄'
, 1000000, 5
);

INSERT
  INTO PRODUCT
(
  PCODE, PNAME, BRAND
, PRICE, STOCK
)
VALUES
(
  null, '투명폰 3', '헬쥐'
, 1000000, 5
);

SELECT * FROM PRODUCT;
SELECT * FROM PRO_DETAIL;

INSERT
  INTO PRO_DETAIL
(
  DCODE, PCODE, PDATE
, AMOUNT, STATUS
)
VALUES
(
  null, 1, CURDATE()
, 5, '입고'
);

INSERT
  INTO PRO_DETAIL
(
  DCODE, PCODE, PDATE
, AMOUNT, STATUS
)
VALUES
(
  null, 2, CURDATE()
, 2, '출고'
);

SELECT * FROM PRODUCT;
SELECT * FROM PRO_DETAIL;

-- -------------------------------------------------------------
DELIMITER //
CREATE OR REPLACE TRIGGER TRG_PRODUCTAFTER 
AFTER INSERT 
ON PRO_DETAIL
FOR EACH ROW
BEGIN
  IF NEW.STATUS = '입고' THEN
    UPDATE PRODUCT A
       SET A.STOCK = A.STOCK + NEW.AMOUNT
     WHERE A.PCODE = NEW.PCODE;
  ELSEIF NEW.STATUS = '출고' THEN
    UPDATE PRODUCT A 
       SET A.STOCK = A.STOCK - NEW.AMOUNT
     WHERE A.PCODE = NEW.PCODE;
  END IF;
END;
//
DELIMITER ;
-- -------------------------------------------------------------












