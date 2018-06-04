
RecyclerView中的一项是倒计时，遇到一个必现的crash

05-25 06:50:31.694 9440-9440 E/AndroidRuntime: FATAL EXCEPTION: main
                                               Process: com.example.cm.bug.rv, PID: 9440
                                               java.lang.IllegalStateException: Cannot call this method while RecyclerView is computing a layout or scrolling android.support.v7.widget.RecyclerView
                                                   at android.support.v7.widget.RecyclerView.assertNotInLayoutOrScroll(RecyclerView.java:2663)
                                                   at android.support.v7.widget.RecyclerView$RecyclerViewDataObserver.onItemRangeChanged(RecyclerView.java:5066)
                                                   at android.support.v7.widget.RecyclerView$AdapterDataObservable.notifyItemRangeChanged(RecyclerView.java:11554)
                                                   at android.support.v7.widget.RecyclerView$AdapterDataObservable.notifyItemRangeChanged(RecyclerView.java:11545)
                                                   at android.support.v7.widget.RecyclerView$Adapter.notifyItemChanged(RecyclerView.java:6778)
                                                   at com.example.cm.bug.rv.BadTimerItemViewHolder.bind(BadAdapter.kt:46)
                                                   at com.example.cm.bug.rv.BadAdapter.onBindViewHolder(BadAdapter.kt:18)
                                                   at com.example.cm.bug.rv.BadAdapter.onBindViewHolder(BadAdapter.kt:13)
                                                   at android.support.v7.widget.RecyclerView$Adapter.onBindViewHolder(RecyclerView.java:6482)
                                                   at android.support.v7.widget.RecyclerView$Adapter.bindViewHolder(RecyclerView.java:6515)
                                                   at android.support.v7.widget.RecyclerView$Recycler.tryBindViewHolderByDeadline(RecyclerView.java:5458)
                                                   at android.support.v7.widget.RecyclerView$Recycler.tryGetViewHolderForPositionByDeadline(RecyclerView.java:5724)

经分析产生这个crash的原因是在`onBindViewHolder()`中调用了`adapter.notifyItemChanged()`。

`RecyclerView$Adapter.bindViewHolder()`时，RecyclerView已进入计算布局的状态 (这个容易理解，因为这时在操作UI)。

而`RecyclerView$RecyclerViewDataObserver.onItemRangeChanged`时会检查是否处于布局状态，如果不执行这个检查的话，可能导致UI跟数据不一致，甚至引起递归调用而陷入死循环的状态。

# 参考

https://stackoverflow.com/questions/45324815/illegalstateexception-cannot-call-this-method-while-recyclerview-is-computing-a

