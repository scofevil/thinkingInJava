package com.scofevil.sort;

/**
 * @author luhaifeng
 *  排序
 */
public abstract class Sort {

    /**
     * 数据源数组
     */
    protected long[] src;
    /**
     * 排序完成目标数组
     */
    protected long[] tar;

    /**
     * 排序数组大小
     */
    protected long   length;

    public Sort(long[] src) {
        this.src = src;
        this.length = src.length;
    }

    /**
     * 对当前目标数据进行排序
     */
    public abstract void sort();

    public long[] getSrc() {
        return src;
    }

    public void setSrc(long[] src) {
        this.src = src;
    }

    public long[] getTar() {
        return tar;
    }

    public void setTar(long[] tar) {
        this.tar = tar;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }
}
