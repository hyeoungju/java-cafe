CREATE TABLE Category (
	cId				BIGINT				PRIMARY KEY AUTO_INCREMENT,
	cName			VARCHAR(40)			NOT NULL

)AUTO_INCREMENT = 2001;

CREATE TABLE MenuItem (
	mId				BIGINT				PRIMARY KEY AUTO_INCREMENT,
	categoryId		BIGINT				NOT NULL,
	menuName		VARCHAR(40)			NOT NULL,
	menuPrice		DOUBLE				NOT NULL,
	menuImgName		VARCHAR(500)		NOT NULL,
	menuQuantity	INT					NOT NULL	DEFAULT  0,
	regDate			TIMESTAMP			NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	
	CONSTRAINT MenuItem_categoryId_FK 
		FOREIGN KEY (categoryId) REFERENCES Category(cId)
)AUTO_INCREMENT = 1001;

CREATE TABLE Cart (
	cartId				BIGINT			PRIMARY KEY 	AUTO_INCREMENT,
	purchaseQuantity	INT				NOT NULL		DEFAULT  0,
	menuItemName		VARCHAR(40)		NOT NULL,
	menuImgName			VARCHAR(500)	NOT NULL,
	menuPrice			DOUBLE			NOT NULL,
	regDate 			TIMESTAMP		NOT NULL		DEFAULT CURRENT_TIMESTAMP
	
)AUTO_INCREMENT = 3001;

SELECT * FROM Cart;



DROP TABLE Cart;
DELETE FROM MenuItem WHERE mId = '1003';
INSERT INTO Category (cName) VALUES ('스무디&프라페');

SELECT mId, categoryId, menuName, menuPrice, menuImgName FROM MenuItem WHERE menuImgName='09eed099baf943f083b724c5de0b61d6.jpg'

SELECT * FROM Category;

SELECT m.mId, m.menuName, m.menuPrice, m.menuImgName, m.menuQuantity FROM MenuItem m
INNER JOIN Category c ON m.categoryId = c.cId WHERE m.categoryId=2001;

