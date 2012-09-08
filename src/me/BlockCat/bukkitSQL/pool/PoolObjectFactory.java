package me.BlockCat.bukkitSQL.pool;

public interface PoolObjectFactory<Type> {
	   public Type newObject();
	}