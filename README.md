
# 内容

Exception发生的原因
commitAllowingStateLoss为什么不可行
fragment的生命周期，尤其是嵌套fragement的生命周期

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

##


# 参考

[android - getting exception "IllegalStateException: Can not perform this action after onSaveInstanceState"](https://stackoverflow.com/questions/7469082/getting-exception-illegalstateexception-can-not-perform-this-action-after-onsa)

[Fragment Transactions & Activity State Loss | Android Design Patterns](http://www.androiddesignpatterns.com/2013/08/fragment-transaction-commit-state-loss.html)

[Understand the Activity Lifecycle  |  Android Developers](https://developer.android.com/guide/components/activities/activity-lifecycle#kotlin)

[Fragments  |  Android Developers](https://developer.android.com/guide/components/fragments)