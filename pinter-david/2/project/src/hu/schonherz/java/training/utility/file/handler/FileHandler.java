package hu.schonherz.java.training.utility.file.handler;

import hu.schonherz.java.training.utility.map.MultiMap;

public interface FileHandler<K, V> {

    MultiMap<K, V> assemble();
    
    MultiMap<K, V>refresh(MultiMap<K, V> multiMap);
}
