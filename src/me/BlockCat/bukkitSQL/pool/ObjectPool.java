package me.BlockCat.bukkitSQL.pool;

import java.util.Stack;

public class ObjectPool<Type> implements Pool<Type> {

	   private final Stack<Type> freeObjects;
	   private PoolObjectFactory<Type> factory;
	   
	   public ObjectPool() {
	      freeObjects = new Stack<Type>();
	   }

	   public void recycle(final Type data) {
	      freeObjects.push(data);
	   }

	   public Type get() {
	      if (freeObjects.isEmpty()) {
	         return factory.newObject();
	      }
	      
	      return freeObjects.pop();
	   }

	   public void setFactory(final PoolObjectFactory<Type> factory) {
	      this.factory = factory;
	   }

	   public void reset() {
	      freeObjects.clear();
	   }

	   public String debug() {
	      return "Current Pool Size: " + freeObjects.size();
	   }
	}