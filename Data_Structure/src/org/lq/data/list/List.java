package org.lq.data.list;

import java.util.Arrays;

/**
 * 列表
 * @author yangpeilin
 *
 */
public class List<E> {
	//标识列表中的元素个数
	private int listSize = 0;
	//标识数组长度
	private int length;
	//存储元素
	private Object [] dataStore = {};
	private int pos; //标识当前位置
	
	public List(){}
	/**
	 * 指定列表元素个数
	 * @param length 个数
	 */
	public List(int length){
		this.length = length;
	}
	
	/**
	 * 添加元素
	 */
	public void append(E e){
		//TODO 未实现 当数组的长度不够存储新添加的内容怎么办?
		this.ensureCapacity(listSize+1);
		//----------------当每次添加一个新的元素的时候,讲元素的实际个数+1
		this.dataStore[this.listSize++] = e;
	}
	/**
	 * 将元素添加到指定的下标位置
	 * @param index 下标
	 * @param e 元素
	 * @return
	 */
	public void insert(int index,E e){
		if(index >-1 || index <= this.listSize){
			int new_index =this.listSize+1;//获得最后一个元素的下标位置
			int old_index = this.listSize;//
			while(old_index >= index){
				//获取插入元素之后的所有元素向后移动一位
				this.dataStore[new_index--] = this.dataStore[old_index--];
			}
			this.dataStore[index] = e;//将元素添加到指定的位置上
			this.listSize++;//元素实际个数+1
			
		}else{
			throw new IllegalArgumentException("元素插入下标["+index+"]错误!");
		}
		
	}
	/**
	 * 根据元素添加,将e添加到agter元素之后
	 * @param e
	 * @param after
	 * a,b,c,d
	 * insert(g,c);
	 * a,b,c,g,d
	 */
	public void insert(E e,E after){
		//TODO 未完成,请扩展
	}
	/**
	 * 清楚列表中所有元素
	 */
	public void clear(){
//		this.dataStore = {};
//		this.dataStore = Arrays.copyOf(this.dataStore, 0);
		for (int i = 0; i < dataStore.length; i++) {
			this.dataStore[i] = null;
		}
		this.listSize = this.length = 0;
	}
	/**
	 * 判断指定元素是否在列表中
	 * @param e 元素
	 * @return
	 */
	public boolean contains(E e){
		for (int i = 0; i < dataStore.length; i++) {
			if(this.dataStore[i].equals(e)){
				return true;
			}
		}
		return false;
	}
	
	
	
	/**
	 * 根据元素查询当前元素在列表中的位置
	 * @param e 元素
	 * @return -1 代表未在列表中找到元素
	 */
	public int find(E e){
		if(e == null){
			return -1;
		}
		for (int i = 0; i < dataStore.length; i++) {
			if(e.equals(dataStore[i])){
				return i;
			}
		}
		return -1;
	}
	/**
	 * 根据元素内容删除指定元素
	 * @param e 元素
	 * @return
	 */
	public boolean  remove(E e){
		int fontAt = find(e);//返回当前元素在列表中的位置
		if(fontAt > -1){
			//----
			while(fontAt < listSize){
				//将下一个元素复制给当前删除的元素
				this.dataStore[fontAt] = this.dataStore[++fontAt];
			}
			//每次删除元素讲列表个数减一
			this.listSize--;
			return true;
		}
		return false;
	}
	/**
	 * 获取首位
	 */
	 public void front(){
		 this.pos = 0;
	 }
	 /**
	  * 获取最后一位
	  */
	 public void end(){
		 this.pos = this.listSize-1;
		 
	 }
	 /**
	  * 向前移动一位
	  */
	 public void prev(){
		 if(this.pos > 0){
			 --this.pos;
		 }
	 }
	 /**
	  * 向后移动一位
	  */
	 public void next(){
		 if(this.pos <= this.listSize-1){
			 ++this.pos;
		 }
	 }
	 /**
	  * 获取当前位置
	  * @return
	  */
	public int currPos(){
		return this.pos;
	}
	/**
	 * 移动到指定位置
	 * @param position
	 */
	public void moveTo(int position){
		this.pos = position;
	}
	/**
	 * 根据游标位置获取元素
	 * @return
	 */
	public E getElement(){
		return (E) this.dataStore[this.pos];
	}
	/**
	 * 返回列表的实例元素个数
	 * @return
	 */
	public int size(){
		return this.listSize;
	}
	/**
	 * 展示列表中的所有元素
	 */
	@Override
	public String toString() {
		return Arrays.toString(this.dataStore).replaceAll(", null", "");
	}
	/**
	 * 数字扩充
	 * @param newIndex 当前添加元素的位置
	 */
	private void ensureCapacity(int newIndex){
		//如果数组长度没有复制,默认创建10长度的数组
		if(this.length == 0){
			this.length = 10;
			this.dataStore = new Object[this.length];
		}else if(newIndex >= length){
			//扩充数组长度的50%
			this.length = this.length + (this.length >> 1);
			//扩充原有数组长度
			this.dataStore = Arrays.copyOf(this.dataStore,this.length);
		}
	}
	
	
	
	
	
	
	
}
