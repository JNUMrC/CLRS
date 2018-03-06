package chapter11;


/**
 * 散列表
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 17:37 2018/1/15
 */
public class HashTable<K, V> {
    public static void main(String[] args) {
        HashTable<Integer,String > t = new HashTable<>();
        t.put(1,"zhangsan");
        t.put(2,"lisi");
        System.out.println(t.size());
        System.out.println(t.get(1));
        System.out.println(t.remove(2));
        System.out.println(t.size());
        System.out.println(t.get(2));

    }
    private Entry<?, ?>[] table;

    private int count = 0;

    public HashTable() {
        this(11);
    }

    public HashTable(int initialCapacity) {
        table = new Entry[initialCapacity];
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public V get(Object key) {
        int hash = key.hashCode();
        Entry<?, ?> tab[] = table;
        int index = (hash & 0x7FFFFFFF) % tab.length;
        for (Entry<?, ?> e = tab[index]; e != null; e = e.next) {
            if ((e.hash == hash) && e.key.equals(key)) {
                return (V) e.value;
            }
        }
        return null;
    }

    private void addEntry(int hash, K key, V value, int index) {
        //TODO 扩容

        Entry<?, ?> tab[] = table;
        Entry<K, V> e = (Entry<K, V>) tab[index];
        tab[index] = new Entry<>(hash, key, value, e);
        count++;
    }

    public V put(K key, V value) {
        int hash = key.hashCode();
        Entry<?, ?> tab[] = table;
        int index = (hash & 0x7FFFFFFF) % tab.length;
        Entry<K, V> entry = (Entry<K, V>) tab[index];
        for (; entry != null; entry = entry.next) {
            if ((entry.hash == hash) && entry.key.equals(key)) {
                V old = entry.value;
                entry.value = value;
                return old;
            }
        }
        addEntry(hash, key, value, index);
        return null;
    }

    public V remove(Object key) {
        Entry<?,?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        Entry<K,V> e = (Entry<K, V>) tab[index];
        for (Entry<K,V> prev = null; e!=null; prev = e, e = e.next) {
            if((e.hash == hash) && e.key.equals(key)){
                if(prev != null){
                    prev.next = e.next;
                }else {
                    tab[index] = e.next;
                }
                count--;
                V old = e.value;
                e.value = null;
                return old;
            }
        }
        return null;
    }

    private class Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Entry<K, V> next;

        public Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public V getValue() {
            return value;
        }

        public K getKey() {
            return key;
        }
    }
}
