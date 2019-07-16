# databinding_autorun
一款插件工具，支持自动生成DataBinding模式的xml布局文件，意在提高开发效率~

![](https://mmbiz.qpic.cn/mmbiz_gif/rmIMUv3sRicCHbbr6rlys6FAgK2KMxYg8iaDnHWsPyNrBoTm8AVSB8k3XyUql7aHycQAmrZBs6QCRg9nj4walXOQ/640?wx_fmt=gif&tp=webp&wxfrom=5&wx_lazy=1)

## 文章解析

[只需三步实现Databinding插件化](https://mp.weixin.qq.com/s?__biz=MzIzNTc5NDY4Nw==&mid=2247483993&idx=1&sn=1c6d7a776a6f8bdc0ce9786fb0087c46&chksm=e8e0fbc9df9772dfdeef5f174e9325010445ac117d5042ea06a81fb3d38d2c597667047c9e46&token=1514380520&lang=zh_CN#rd)

## 安装方式
由于目前还未提交审核，后续会发布到jetbrains。

如果你现在就想体验，可以点击下载[databinding_autorun-1.0.1.jar](https://github.com/idisfkj/databinding_autorun/raw/master/databinding_autorun-1.0.1.jar)文件

亦或者你可以将项目代码clone到你的本地，然后再到Intellij IDEA中进行构建buildPlugin task。构建成功之后，你可以到build->libs下找到databinding_autorun-1.0.1.jar文件。

最后拿到jar文件后，到Android Studio的plugin安装页进行本地install就可以了。

## 使用方式
与Android Studio原生创建xml布局文件一样，在弹窗选择框时，选择Databinding layout resources file选项即可。具体操作效果如下

![](https://mmbiz.qpic.cn/mmbiz_png/rmIMUv3sRicCHbbr6rlys6FAgK2KMxYg87feWtHcibWZibYyXgweTNrVQxSLP3QGvgb23ZQf7NDIiaAMBIvYs9ROkw/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)

为了提高便捷度，你也可以在插件的设置页面设置默认的Root Element，如下图所示

![](https://mmbiz.qpic.cn/mmbiz_png/rmIMUv3sRicCHbbr6rlys6FAgK2KMxYg8acQNIRPS7qDbwOG8eqGoh69GLaHbS95xvAJSD831xriccIYmG7GXWYA/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)

## Issues
如果在使用的过程中有任何问题或者不便的地方，欢迎@我，或者直接提交Issue，我会第一时间进行改善~