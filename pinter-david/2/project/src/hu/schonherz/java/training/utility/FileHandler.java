package hu.schonherz.java.training.utility;

public interface FileHandler<K, V> {

    MultiMap<K,V> read();
    
    MultiMap<K, V>refresh(MultiMap<K, V> multiMap);
}
