ip 10.109.246.70
/root/house/nginx-1.12.2
yum -y install pcre-devel openssl openssl-devel
mkdir /root/house/nginx
./configure --prefix=/root/house/nginx
make && make install
安装好以后在/root/house/nginx里
修改conf下的nginx.conf
![](https://ws4.sinaimg.cn/large/006tKfTcly1fnhjnb3hc8j30a805d3yv.jpg)

启动命令
```bash
sbin/nginx
```
![](https://ws1.sinaimg.cn/large/006tKfTcly1fnhjotjupmj30hd02fmxt.jpg)

------


macos

brew install nginx
vim /usr/local/etc/nginx/nginx.conf
nginx命令启动