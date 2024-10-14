package hashmap;

import java.util.HashMap;

public class HashMapInternalFunction {

    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put(new Key("sachin"), 30);
        map.put(new Key("vi"), 20);
        map.put(new Key("vi"), 40);

        map.forEach((key,value) -> {
            System.out.println("key hashcode " +key.hashCode() +" value ="+value);
        });

    }
}

class Key {
    public String key;

    Key(String key)
    {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public int hashCode() {
        return key.charAt(0);
    }

//    @Override
//    public boolean equals(Object obj) {
//        return getKey().equals(((Key)obj).getKey());
//    }
}
