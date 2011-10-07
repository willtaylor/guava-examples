package com.dealer.guava.collect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * Simple example of using {@link Multimap}
 * 
 * @author Will Taylor
 *
 */
public class MultimapExample {

    public static void before() {
        // lots of typing, just to declare and instantiate the object
        Map<String, List<Integer>> myMap = new HashMap<String, List<Integer>>();

        for ( int i = 0; i < 5; ++i ) {
            String key = String.format("key%d", i);

            for ( int j = 0; j < i + 1; ++j ) {
                // and more typing to create the list upon first access
                List<Integer> temp = myMap.get(key);

                if ( temp == null ) {
                    temp = new ArrayList<Integer>();
                }

                temp.add(j);
            }
        }
    }

    public static void main(String ... args) {
        // a little less typing!
        Multimap<String, Integer> myMap = ArrayListMultimap.create();

        for ( int i = 0; i < 5; ++i ) {
            String key = String.format("key%d", i);

            for ( int j = 0; j < i + 1; ++j ) {
                // way less typing!
                myMap.put(key, j);
            }
        }

        System.out.println("Iterating through Multimap entries");
        for ( Entry<String, Integer> entry : myMap.entries() ) {
            // one key-value pair for each insertion
            System.out.println(String.format("key[%s] -> value[%s]", entry.getKey(), entry.getValue()));
        }

        System.out.println("\nThings get a little more interesting this way...");
        for ( String key : myMap.keySet() ) {
            // Collection of values for each key
            Collection<Integer> list = myMap.get(key);
            System.out.println(String.format("key[%s] -> value[%s]", key, list));
        }
    }
}
