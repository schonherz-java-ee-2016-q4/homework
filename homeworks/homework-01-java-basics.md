## 1. Házi Feladat - MultiMap
### Határidő: November 18, Péntek, 15:00

**A feladat a következő**:  
Egyszerű multimap implementáció.  
A multimap egy olyan kulcs-érték struktúra, amelyben egy adott kulcshoz több érték is hozzárendelhető.  
Készítsetek egy Java projektet, amelyben legyen egyetlen osztály. Ez az osztály implementálja az alábbi `MultiMap` generikus interface-t. (Ehhez értelemszerűen készítsetek a projektetekben egy interface-t, belemásolva az alábbi kódot.)

```java
public interface MultiMap<K, V> {

    public void clear();

    public boolean containsKey(Object key);

    boolean containsValue(Object value);

    public Collection<V> get(Object key);

    public boolean isEmpty();

    public V put(K key, V value);

    public Collection<V> remove(Object key);

    public Object remove(Object key, Object value);

    public int size();

    public boolean equals(Object o);

    public int hashCode();

}
```

**Beadás menete**:  
A master branchen csináljon magának mindenki egy könyvtárat a saját nevével. Ebben a könyvtárban hozzon létre a házi sorszámának megfelelően elnevezett könyvtárat.  
Ebbe a könyvtárba dolgozzátok ki a feladatot.
Szóval ha engem Vályogvető Arisztotelésznek hívnának, akkor /valyogveto-arisztotelesz/1/ alá dolgoznék.

Jó munkát, jó szurkolást, bármilyen kérdés, észrevétel van, keressetek bátran Facebookon, faxon, galambpostán!
