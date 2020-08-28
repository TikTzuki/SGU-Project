
```
useEffect(()=>{
    //Code logic here
}, []);
```
Với tham số thứ 2 là một mảng rỗng, cách viết sẽ xử lý tương tự `componentDidMount()` - được gọi 1 lần khi component được mounted.

Nhưng nếu function được sử dụng trong tham số đầu tiên return về một function khác. Thì hàm được return sẽ được kích hoạt ngay trước khi component bị unmounted - tương đương với callback `componentWillUnmount()`
```
useEffect(()=>{
    return ()=>{
        //Hàm được trả về sẽ được gọi khi component unmount
        //Bạn viết code xử lý logic tại đây khi component unmount
    }
}, [])
```