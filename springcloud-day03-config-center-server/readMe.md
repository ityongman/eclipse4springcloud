使用git作为注册中心的方法
1. 在本地生成公钥 public_rsa(可以百度进行相关查询)
2. 在git仓库配置步骤1中生成公钥
3. 通过命令 git clone -b master git_url 测试权限是否配置成功
4. 将相关的git信息配置到application.properties中

经过上面的方式可以测试 成功