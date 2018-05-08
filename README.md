
# 内容

Exception发生的原因
commitAllowingStateLoss为什么不可行
fragment的生命周期，尤其是嵌套fragement的生命周期

# 生命周期方法

attach()和add()后Fragment生命周期变化的差异。

对一个Fragment执行add()操作后，其生命周期变化如下：

onAttach() -> onCreate() -> onCreateView() -> onStart() -> onResume()

接下来再做remove()操作，生命周期变化：

onPause() -> onStop() -> onDestroyView() -> onDestroy() -> onDetach()

如果add()后detach()，则生命周期变化与remove()有所不同

onPause() -> onStop() -> onDestroyView()

可以看到，并没有执行onDestroy()和onDetach()。所以，detach()后是可以再次将fragment attach()回来的

onCreateView() -> onStart() -> onResume()

# demo

## TabLayout + ViewPager

https://developer.android.com/reference/android/support/design/widget/TabLayout

TabLayout + ViewPager方式实现的Tab页

注意off screen特性对生命周期的影响

## FragmentTabHost

https://www.jianshu.com/p/e9c00493aa7e

https://www.jianshu.com/p/491386d6435c

FragmentTabHost方式实现的Tab页

没有off screen特性，所以生命周期跟TabLayout + ViewPager方式有所不同

## ViewPager是如何影响Fragment的生命周期的




##


# 参考

[android - getting exception "IllegalStateException: Can not perform this action after onSaveInstanceState"](https://stackoverflow.com/questions/7469082/getting-exception-illegalstateexception-can-not-perform-this-action-after-onsa)

[Fragment Transactions & Activity State Loss | Android Design Patterns](http://www.androiddesignpatterns.com/2013/08/fragment-transaction-commit-state-loss.html)

[Understand the Activity Lifecycle  |  Android Developers](https://developer.android.com/guide/components/activities/activity-lifecycle#kotlin)

[Fragments  |  Android Developers](https://developer.android.com/guide/components/fragments)

https://blog.csdn.net/jemenchen/article/details/52645380