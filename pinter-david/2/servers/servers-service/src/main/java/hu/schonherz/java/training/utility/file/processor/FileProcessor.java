package hu.schonherz.java.training.utility.file.processor;

import hu.schonherz.java.training.utility.map.MultiMap;

public interface FileProcessor<K,V> {
    
    MultiMap<K, V> process();
    
}
