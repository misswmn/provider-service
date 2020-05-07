package com.roncoo.eshop.javase;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author wangmn
 * @version 1.0
 * @description
 * @date 2020/3/18 12:28
 */
class GCTarget {
    // 对象的ID
    public String id;

    // 占用内存空间
    byte[] buffer = new byte[1024];

    public GCTarget(String id) {
        this.id = id;
    }

    protected void finalize() throws Throwable {
        // 执行垃圾回收时打印显示对象ID
        System.out.println("Finalizing GCTarget, id is : " + id);
    }
}

public class GCTargetWeakReference extends WeakReference<GCTarget> {
    // 弱引用的ID
    public String id;

    public GCTargetWeakReference(GCTarget gcTarget,
                                 ReferenceQueue<? super GCTarget> queue) {
        super(gcTarget, queue);
        this.id = gcTarget.id;
    }

    protected void finalize() {
        System.out.println("Finalizing GCTargetWeakReference " + id);
    }
}
