1. [forEach](#forEach)
2. includes
3. filter
4. map
5. reduce
6. some
7. every
8. sort
9. Array.from
10. Array.of
11. Array.prototype.entries()
12. Array.prototype.copyWithin()

## **1. forEach**
```javascript
const arr = [1,2,3,4,5,6];
arr.forEach(item => {
    console.log(item);
});
```
## **2. includes**
```javascript
const arr = ['Tik', 2, 3, 4, 5, 6];

arr.includes('Tik'); //output: true
arr.includes(7); //output: false
```
## **3. filter**
The filter() method creates an array filled with all array elements that pass a test (provided as a function).  
**Note:** filter() does not execute the function for array elements without values.  
**Note:** filter() does not change the original array.
```javascript
const arr = [1, 2, 3, 4, 5, 6];

const filtered = arr.filter(num => num > 2);
console.log(filtered); //output: [3, 4, 5, 6]
```
## **4. map**

```javascript
const arr = [1, 2, 3, 4, 5, 6];

const oneAdded = arr.map(num => num + 1);

console.log(oneAdded); //output [2, 3, 4, 5, 6, 7]
console.log(arr); //output [1, 2, 3, 4, 5, 6]
```
## **5. reduce**
The reduce() method reduces the array to a single value.  
The reduce() method executes a provided function for each value of the array (from left-to-right).  
The return value of the function is stored in an accumulator (result/total).  
**Note:** reduce() does not execute the function for array elements without values.  
**Note:** this method does not change the original array.  
```javascript
var number = [15.5, 2.3, 1.1, 4.7];

function getSum(total, currentValue, currentIndex, arrayTheCurrentElementBelongs){
    return total + Math.round(currentValue);
}

console.log(numbers.reduce(getSum, 2)); //output: 26
```
## **6. some**
```javascript
const arr = [3, 9, 7, 6];
const idiot = arr.some(num => num < 5);
console.log(idiot); // output: true
```
## **7. every**
```javascript
const arr = [1, 2, 3, 4, 5, 6];

const greterFour = arr.every(num => num >4);
console.log(greterFour); //output: false
const lessTen = arr.every(num => num < 10);
console.log(lessTen); //ouput: true
```
## **8. sort**

```javascript
const arr = [1, 2, 3, 4, 5, 6];
const alpha = ['e', 'a', 'c', 'u', 'y'];

descOrder = arr.sort((a,b) => a > b ? -1 : 1);
console.log(descOrder);//output: [6,5,4,3,2,1]

ascOrder = alpha.sort((a, b) => a > b ? 1 : -1);
console.log(ascOrder); //outpur: ['a', 'c', 'e', 'u', 'y']
```
## **9. Array.from**
```javascript
const name = 'javascript'
const nameArray = Array.from(name);

console.log(name); //output: java
console.log(nameArray); //output: ['j', 'a', 'v', 'a']

const lis = document.querySelectorAll('li');
const lisArray = Array.from(document.querySelectorAll('li'));

console.log(Array.isArray(lis)); //output: false
console.log(Array.isArray(lisArray)); //output: true
```
## **10. Array.of**
```javascript
const nums = Array.of(1, 2, 3, 4, 5, 6);
console.log(nums); //output: [1, 2, 3, 4, 5, 6]
```
## **11. Array.prototype.entries()**
```javascript
var arr = ["a", "b", "c"];
var iterator = arr.entries();
console.log(iterator);
/*
    Array Iterator {}
         __proto__:Array Iterator
         next:ƒ next()
         Symbol(Symbol.toStringTag):"Array Iterator"
         __proto__:Object
*/
for (let e of iterator){
    console.log(e);
}
// [0, "a"]
// [1, "b"]
// [2, "c"]
```
## **12. Array.protoype.copyWithin()**

```javascript
let numbers = [1, 2, 3, 4, 5];

numbers.copyWithin(-2);
// [1, 2, 3, 1, 2]

numbers.copyWithin(0, 3);
// [4, 5, 3, 4, 5]

numbers.copyWithin(0, 3, 4);
// [4, 2, 3, 4, 5]

numbers.copyWithin(-2, -3, -1);
// [1, 2, 3, 3, 4]

[].copyWithin.call({ length: 5, 3: 1 }, 0, 3);
// {0: 1, 3: 1, length: 5}

// ES2015 Typed Arrays are subclasses of Array
var i32a = new Int32Array([1, 2, 3, 4, 5]);

i32a.copyWithin(0, 2);
// Int32Array [3, 4, 5, 4, 5]

// On platforms that are not yet ES2015 compliant:
[].copyWithin.call(new Int32Array([1, 2, 3, 4, 5]), 0, 3, 4);
// Int32Array [4, 2, 3, 4, 5]
```
