## 1.基本概念

### 1.1 什么是认证

简单的说就是我们在输入账号密码进行登录的过程就是认证。它的目的就是为了保护系统的隐私数据和资源，
用户的身份合法才可以访问该系统的资源。

- 认证: 用户认证就是判断一个用户是否合法的过程。
- 常见的用户认证方式: 用户名和密码，二维码登录，手机短信登录，指纹认证等。

### 1.2 什么是会话

用户认证通过后，为了避免用户的每次操作都进行认证可将用户的信息保存在会话中，会话就是系统为了
保护当前用户的登录状态所提供的机制，常见的有基于Session方式，基于token方式等。

- 基于Session: 它的交互流程是，用户认证成功后，在服务端生成用户相关的数据保存在Session
（当前会话中），发送给客户端的session_id存在cookie中，这样用户客户端请求时带上session_id
就可以验证服务器端是否存在session数据，以此完成用户的合法性校验，当前用户退出系统或session
过期销毁时，客户端的session_id也就无效了。

- 基于token（令牌）: 它的交互流程，用户认证成功后，服务端生成一个token发送给客户端，客户端可以放
到cookie或者localStorage等存储中，每次请求带上token，服务端收到token通过验证后即可确认
用户信息。
```text
   基于session的认证方式由servlet规范定制，服务端要存储session信息需要占用内存资源，
客户端需要支持cookie;而基于token的方式一般不需要服务端存储token，并且不限制客户端存
储方式。如今互联网时代更多的客户需要接入系统，系统多是采用前后端分离的架构进行实现，所以
基于token的方式更合适。
```
### 1.3 什么是授权

拿微信举例子，微信登录后用户即可使用微信的功能，比如，发红包、发朋友圈、添加好友等，没有绑定
银行卡的用户是无法发送红包的，绑定银行卡的用户才可以发送红包，收红包等功能。而这些发朋友圈、
添加好友、发红包功能都是微信的资源即功能资源，用户拥有发红包的功能权限才可以正常使用发送红包
功能，拥有发送红包功能权限才可以使用发送朋友圈的功能，这个根据用户的权限来控制使用资源的过程
就是授权

- 为什么要授权
  - 认证是为了保护用户的合法性，授权则是为了更细粒度的对隐私数据进行划分，授权是在认证通过后
    发生的，控制不同的用户能够访问不同的资源，用户有权限就可以访问该资源，没有权限就不可以
    访问。

### 1.4 授权的数据模型

简单来说就是Who对What（which）进行How操作，包括如下:
- Who  即主体（Subject），主体一般指用户，也可以是程序，需要访问系统中的资源

- What 即资源（Resource），如系统菜单、页面、按钮、代码方法、系统商品信息、系统订单
信息等。系统菜单、页面、按钮、代码方法都属于系统功能资源、对于web系统每个功能资源通常对
应一个URL;系统的商品信息、系统订单信息都属于实体资源（数据资源），实体资源由资源类型和
资源实例组成，比如商品信息为资源类型，商品编号为001的商品为资源实例。

- How  权限/许可（Permission），规定了用户对资源的操作许可，权限离开资源没有意义，如
用户查询权限、用户添加权限、某个代码方法的调用权限、编号为001的用户修改权限等、通过权限
可知用户对哪些资源都有操作许可。

- 授权一般基于五张表：
```text
用户表
角色表
权限表（这里包括资源和权限、 权限id、 权限标识、 权限名称、 资源名称、 资源访问路径）
用户角色中间表
角色权限中间表
```