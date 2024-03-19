/* 01. object-distructuring-assignment-basic-syntax(객체 구조분해 할당 기본 문법) */

let pants = {
    productName: '배기팬츠',
    color: '검정색',
    price: 30000,
    getInfo() {
        console.log(this.productName, '좋아!');
    }
};

// let productName = pants.productName;
// let color = pants.color;
// let price = pants.price;

// let {productName, color, price} = pants;
let {color, productName, price, getInfo} = pants;

console.log(productName, color, price);

console.log(getInfo);
getInfo();