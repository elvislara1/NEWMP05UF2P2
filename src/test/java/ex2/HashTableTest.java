package ex2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

class HashTableTest {
    //TODO Put and Drop:
    @org.junit.jupiter.api.Test
    void prueba_drop_y_put() {
        HashTable ht = new HashTable();

        //Añadir valores al HASHTABLE
        for (int i = 0; i < 40; i++) {
            final String key = String.valueOf(i);
            final String value = String.valueOf(i);
            ht.put(key, value);
        }

        Assertions.assertEquals("\n bucket[0] = [0, 0] -> [11, 11] -> [22, 22] -> [33, 33]\n" +
                " bucket[1] = [1, 1] -> [12, 12] -> [23, 23] -> [34, 34]\n" +
                " bucket[2] = [2, 2] -> [13, 13] -> [24, 24] -> [35, 35]\n" +
                " bucket[3] = [3, 3] -> [14, 14] -> [25, 25] -> [36, 36]\n" +
                " bucket[4] = [4, 4] -> [15, 15] -> [26, 26] -> [37, 37]\n" +
                " bucket[5] = [5, 5] -> [16, 16] -> [27, 27] -> [38, 38]\n" +
                " bucket[6] = [6, 6] -> [17, 17] -> [28, 28] -> [39, 39]\n" +
                " bucket[7] = [7, 7] -> [18, 18] -> [29, 29]\n" +
                " bucket[8] = [8, 8] -> [19, 19]\n" +
                " bucket[9] = [9, 9]\n" +
                " bucket[13] = [30, 30]\n" +
                " bucket[14] = [20, 20] -> [31, 31]\n" +
                " bucket[15] = [10, 10] -> [21, 21] -> [32, 32]", ht.toString());

        //borramos el primer valor
        ht.drop("5");
        //borramos el ultimo valor
        ht.drop("35");
        //borramos uno del medio
        ht.drop("14");
        //otro del medio
        ht.drop("15");
        //borramos el valor del bucket
        ht.drop("9");

        Assertions.assertEquals("\n bucket[0] = [0, 0] -> [11, 11] -> [22, 22] -> [33, 33]\n" +
                " bucket[1] = [1, 1] -> [12, 12] -> [23, 23] -> [34, 34]\n" +
                " bucket[2] = [2, 2] -> [13, 13] -> [24, 24]\n" +
                " bucket[3] = [3, 3] -> [25, 25] -> [36, 36]\n" +
                " bucket[4] = [4, 4] -> [26, 26] -> [37, 37]\n" +
                " bucket[5] = [16, 16] -> [27, 27] -> [38, 38]\n" +
                " bucket[6] = [6, 6] -> [17, 17] -> [28, 28] -> [39, 39]\n" +
                " bucket[7] = [7, 7] -> [18, 18] -> [29, 29]\n" +
                " bucket[8] = [8, 8] -> [19, 19]\n" +
                " bucket[13] = [30, 30]\n" +
                " bucket[14] = [20, 20] -> [31, 31]\n" +
                " bucket[15] = [10, 10] -> [21, 21] -> [32, 32]", ht.toString());

        Assertions.assertEquals(16, ht.size());
        Assertions.assertEquals(35, ht.count());

        //DUPLICADOS
        //Inicio
        ht.put("8", "new");

        Assertions.assertEquals("\n bucket[0] = [0, 0] -> [11, 11] -> [22, 22] -> [33, 33]\n" +
                " bucket[1] = [1, 1] -> [12, 12] -> [23, 23] -> [34, 34]\n" +
                " bucket[2] = [2, 2] -> [13, 13] -> [24, 24]\n" +
                " bucket[3] = [3, 3] -> [25, 25] -> [36, 36]\n" +
                " bucket[4] = [4, 4] -> [26, 26] -> [37, 37]\n" +
                " bucket[5] = [16, 16] -> [27, 27] -> [38, 38]\n" +
                " bucket[6] = [6, 6] -> [17, 17] -> [28, 28] -> [39, 39]\n" +
                " bucket[7] = [7, 7] -> [18, 18] -> [29, 29]\n" +
                " bucket[8] = [8, new] -> [19, 19]\n" +
                " bucket[13] = [30, 30]\n" +
                " bucket[14] = [20, 20] -> [31, 31]\n" +
                " bucket[15] = [10, 10] -> [21, 21] -> [32, 32]", ht.toString());

        Assertions.assertEquals(16, ht.size());
        Assertions.assertEquals(35, ht.count());

        //Borrar inexistentes
        ht.drop("31");
        ht.drop("31");
        ht.drop("32");
        ht.drop("32");
        ht.drop("2");

        Assertions.assertEquals("\n bucket[0] = [0, 0] -> [11, 11] -> [22, 22] -> [33, 33]\n" +
                " bucket[1] = [1, 1] -> [12, 12] -> [23, 23] -> [34, 34]\n" +
                " bucket[2] = [13, 13] -> [24, 24]\n" +
                " bucket[3] = [3, 3] -> [25, 25] -> [36, 36]\n" +
                " bucket[4] = [4, 4] -> [26, 26] -> [37, 37]\n" +
                " bucket[5] = [16, 16] -> [27, 27] -> [38, 38]\n" +
                " bucket[6] = [6, 6] -> [17, 17] -> [28, 28] -> [39, 39]\n" +
                " bucket[7] = [7, 7] -> [18, 18] -> [29, 29]\n" +
                " bucket[8] = [8, new] -> [19, 19]\n" +
                " bucket[13] = [30, 30]\n" +
                " bucket[14] = [20, 20]\n" +
                " bucket[15] = [10, 10] -> [21, 21]", ht.toString());

        Assertions.assertEquals(16, ht.size());
        Assertions.assertEquals(32, ht.count());
    }
    //Put Sin Colison
    @org.junit.jupiter.api.Test
    void putSinColision() {
        HashTable hashTable = new HashTable();

        Assertions.assertEquals("",hashTable.toString());
        hashTable.put("1","1");
        hashTable.put("2","2");
        hashTable.put("3","3");
        hashTable.put("4","4");

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, 1]\n" +
                " bucket[2] = [2, 2]\n" +
                " bucket[3] = [3, 3]\n" +
                " bucket[4] = [4, 4]",hashTable.toString());
    }

    @org.junit.jupiter.api.Test
    void putMismaKey() {
        HashTable hashTable = new HashTable();

        Assertions.assertEquals("",hashTable.toString());
        hashTable.put("1","1");
        hashTable.put("2","2");
        hashTable.put("3","3");
        hashTable.put("4","4");
        hashTable.put("13","13");

        hashTable.put("2","new");
        //Numero 2 se actualiza

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, 1]\n" +
                " bucket[2] = [2, new] -> [13, 13]\n" +
                " bucket[3] = [3, 3]\n" +
                " bucket[4] = [4, 4]",hashTable.toString());
    }

    //TODO Count:
    // S'ha de repetir tot el que s'ha fet amb "put" i comprovar amb "count" que el número de nodes és correcte.
    // S'ha de repetir tot el que s'ha fet amb "drop" i comprovar amb "count" que el número de nodes és correcte.
    @org.junit.jupiter.api.Test
    void count() {
        HashTable hashTable = new HashTable();
        for (int i = 0; i < 50; i++){
            final String key = String.valueOf(i);
            final String value  = String.valueOf(i);
            hashTable.put(key, value);
        }
        Assertions.assertEquals(50, hashTable.count());
        Assertions.assertEquals(16, hashTable.size());

        for (int i = 0; i < 50; i++){
            hashTable.drop(String.valueOf(i));
        }
        Assertions.assertEquals(0, hashTable.count());
        Assertions.assertEquals(16, hashTable.size());
    }

    //TODO Size
    // S'ha de repetir tot el que s'ha fet amb "put" i comprovar amb "size" que el tamany de la taula és correcte.
    // S'ha de repetir tot el que s'ha fet amb "drop" i comprovar amb "size" que el tamany de la taula és correcte.:
    @org.junit.jupiter.api.Test
    void size() {
        HashTable hashTable = new HashTable();
        for (int i = 0; i < 90; i++){
            final String key = String.valueOf(i);
            final String value  = String.valueOf(i);
            hashTable.put(key, value);
        }
        Assertions.assertEquals(90, hashTable.count());
        Assertions.assertEquals(16, hashTable.size());
    }

    //TODO Get
    @org.junit.jupiter.api.Test
    void get() {
        HashTable ht = new HashTable();

        //Añadir valores al hashtable
        for (int i = 0; i < 35; i++) {
            final String key = String.valueOf(i);
            ht.put(key, key);
        }

        String primero = ht.get("1"); //coger el primero
        String medio = ht.get("15"); //coger el del medio
        String ultimo = ht.get("30"); //coger el ultimo

        Assertions.assertEquals("1", primero);
        Assertions.assertEquals("15", medio);
        Assertions.assertEquals("30", ultimo);
    }

    @org.junit.jupiter.api.Test
    void getInexistente() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","1");
        hashTable.get("12");
        Assertions.assertEquals(null,hashTable.get("12"));
    }
}