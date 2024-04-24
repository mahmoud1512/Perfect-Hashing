package org.example.Methods;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class NSpaceTest {

    @Test
    void Integer_insertion_with_search()
    {
        NSpace<Integer>x=new NSpace<>(32,10);
        for (int i = 0; i < 100; i++) {
            assertTrue(x.insert(i));
        }
        assertTrue(x.search(10));
        assertTrue(x.search(25));
        assertFalse((x.search(1000)));
    }
    @Test
    void Integer_insert_delete_search()
    {
        NSpace<Integer>x=new NSpace<>(32,10);
        for (int i = 0; i < 1000; i++) {
            assertTrue(x.insert(i));
        }
        for (int i = 0; i < 100; i++) {
            assertTrue(x.search(i));
        }
        for (int i = 0; i < 50; i++) {
            assertTrue(x.delete(i));
        }
        assertFalse(x.delete(10));
        assertFalse(x.search(10));
    }
    @Test
    void Integer_Batch_insert_and_search()
    {
        ArrayList<Integer>arrayList=new ArrayList<Integer>();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
        }
        NSpace<Integer>x=new NSpace<>(32,10);
        int []result=x.batchInsert(arrayList);
        assertEquals(0,result[0]);
        assertEquals(10000,result[1]);
        ArrayList<Integer>arrayList2=new ArrayList<Integer>();
        for (int i = 9000; i <= 10000; i++) {
            arrayList2.add(i);
        }
        result=x.batchInsert(arrayList2);
        assertEquals(1000,result[0]);
        assertEquals(1,result[1]);

        assertTrue(x.search(10000));

    }
    @Test
    void Integer_Batch_delete()
    {
        ArrayList<Integer>arrayList=new ArrayList<Integer>();
        ArrayList<Integer>arrayList2=new ArrayList<Integer>();
        ArrayList<Integer>arrayList3=new ArrayList<Integer>();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
            if(i%2==0)
            {
                arrayList2.add(i);
            }

        }

        NSpace<Integer>x=new NSpace<>(32,10);
        int []result=x.batchInsert(arrayList);
        assertEquals(0,result[0]);
        assertEquals(10000,result[1]);
        result=x.batchDelete(arrayList2);
        assertEquals(5000,result[0]);
        assertEquals(0,result[1]);
        for (int i = 5000; i <10000 ; i+=2) {
            assertTrue(x.insert(i));
        }
        for(int i=5000;i<15000;i+=2)
        {
            arrayList3.add(i);
        }
        result=x.batchDelete(arrayList3);
        assertEquals(2500,result[0]);
        assertEquals(2500, result[1]);
    }
    @Test
    void Integer_Multiple_insertions()
    {
        NSpace<Integer>x=new NSpace<>(32,10);
        for (int i = 0; i < 10; i++) {
            assertTrue(x.insert(i));
        }
        ArrayList<Integer>arrayList=new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(9);
        arrayList.add(10);
        int[] result=x.batchInsert(arrayList);
        assertEquals(3,result[0]);
        assertEquals(1,result[1]);
    }
    @Test
    void Integer_Multiple_deletion()
    {
        NSpace<Integer>x=new NSpace<>(32,10);
        ArrayList<Integer>arrayList=new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            assertTrue(x.insert(i));
        }
        for (int i = 33; i < 134; i++) {
           arrayList.add(i);
        }
        int[]result=x.batchDelete(arrayList);
        assertEquals(67,result[0]);
        assertEquals(34,result[1]);
        assertTrue(x.search(10));
        assertFalse(x.search(35));
    }

    @Test
    void Long_insertion_with_search()
    {
        NSpace<Long>x=new NSpace<>(64,12);
        for (Long i = 0L; i < 100; i++) {
            assertTrue(x.insert(i));
        }
        assertTrue(x.search(10L));
        assertTrue(x.search(25L));
        assertFalse((x.search(1000L)));
    }
    @Test
    void Long_insert_delete_search()
    {
        NSpace<Long>x=new NSpace<>(64,12);
        for (Long i = 0L; i < 1000; i++) {
            assertTrue(x.insert(i));
        }
        for (Long i = 0L; i < 100; i++) {
            assertTrue(x.search(i));
        }
        for (Long i = 0L; i < 50; i++) {
            assertTrue(x.delete(i));
        }
        assertFalse(x.delete(10L));
        assertFalse(x.search(10L));
    }
    @Test
    void Long_Batch_insert_and_search()
    {
        ArrayList<Long>arrayList=new ArrayList<Long>();
        for (Long i = 0L; i < 10000; i++) {
            arrayList.add(i);
        }
        NSpace<Long>x=new NSpace<>(64,12);
        int []result=x.batchInsert(arrayList);
        assertEquals(0,result[0]);
        assertEquals(10000,result[1]);
        ArrayList<Long>arrayList2=new ArrayList<Long>();
        for (Long i = 9000L; i <= 10000; i++) {
            arrayList2.add(i);
        }
        result=x.batchInsert(arrayList2);
        assertEquals(1000,result[0]);
        assertEquals(1,result[1]);

        assertTrue(x.search(10000L));

    }
    @Test
    void Long_Batch_delete()
    {
        ArrayList<Long>arrayList=new ArrayList<Long>();
        ArrayList<Long>arrayList2=new ArrayList<Long>();
        ArrayList<Long>arrayList3=new ArrayList<Long>();
        for (Long i = 0L; i < 10000; i++) {
            arrayList.add(i);
            if(i%2==0)
            {
                arrayList2.add(i);
            }

        }

        NSpace<Long>x=new NSpace<>(64,12);
        int []result=x.batchInsert(arrayList);
        assertEquals(0,result[0]);
        assertEquals(10000,result[1]);
        result=x.batchDelete(arrayList2);
        assertEquals(5000,result[0]);
        assertEquals(0,result[1]);
        for (Long i = 5000L; i <10000 ; i+=2) {
            assertTrue(x.insert(i));
        }
        for(Long i=5000L;i<15000;i+=2)
        {
            arrayList3.add(i);
        }
        result=x.batchDelete(arrayList3);
        assertEquals(2500,result[0]);
        assertEquals(2500, result[1]);
    }
    @Test
    void Long_Multiple_insertions()
    {
        NSpace<Long>x=new NSpace<>(64,12);
        for (Long i = 0L; i < 10; i++) {
            assertTrue(x.insert(i));
        }
        ArrayList<Long>arrayList=new ArrayList<Long>();
        arrayList.add(1L);
        arrayList.add(2L);
        arrayList.add(9L);
        arrayList.add(10L);
        int[] result=x.batchInsert(arrayList);
        assertEquals(3,result[0]);
        assertEquals(1,result[1]);
    }
    @Test
    void Long_Multiple_deletion()
    {
        NSpace<Long>x=new NSpace<>(64,12);
        ArrayList<Long>arrayList=new ArrayList<Long>();
        for (long i = 0L; i < 100; i++) {
            assertTrue(x.insert(i));
        }
        for (long i = 33L; i < 134; i++) {
            arrayList.add(i);
        }
        int[]result=x.batchDelete(arrayList);
        assertEquals(67,result[0]);
        assertEquals(34,result[1]);
        assertTrue(x.search(10L));
        assertFalse(x.search(35L));
    }

    @Test
    void String_insert_search()
    {
        NSpace<String>x=new NSpace<>(80,12);
        assertTrue(x.insert("mohamed"));
        assertTrue(x.insert("Omar"));
        assertTrue(x.insert("radwa"));
        assertFalse(x.insert("mohamed"));
        assertTrue( x.insert("ssss"));
        assertTrue(x.search("ssss"));
        assertFalse(x.search("tntyn"));
    }

    @Test
    void String_insert_delete_search()
    {
        NSpace<String>x=new NSpace<>(80,12);
        assertTrue(x.insert("mohamed"));
        assertTrue(x.insert("Omar"));
        assertTrue(x.insert("radwa"));
        assertFalse(x.insert("mohamed"));
        assertTrue( x.insert("ssss"));
        assertTrue(x.insert("Mango"));
        assertTrue(x.insert("kiwi"));
        assertTrue(x.delete("mohamed"));
        assertFalse(x.delete("Yehia"));
        assertFalse(x.search("mohamed"));
        assertTrue(x.search("Omar"));
    }

    @Test
    void String_batch_insertion()
    {
        NSpace<String>x=new NSpace<>(80,12);
        ArrayList<String>arrayList=new ArrayList<>();
        arrayList.add("kiwi");
        arrayList.add("koko");
        arrayList.add("tytyty");
        arrayList.add("kiwi");
        arrayList.add("mahmoud");
        arrayList.add("mahmoud");
        int []result=x.batchInsert(arrayList);
        assertEquals(2,result[0]);
        assertEquals(4,result[1]);
    }

    @Test
    void String_batch_deletion()
    {

        NSpace<String>x=new NSpace<>(80,12);
        ArrayList<String>arrayList=new ArrayList<>();
        arrayList.add("kiwi");
        arrayList.add("koko");
        arrayList.add("tytyty");
        arrayList.add("kiwe");
        arrayList.add("Mahmoud");
        arrayList.add("mahmoud");
        int []result=x.batchInsert(arrayList);
        assertEquals(0,result[0]);
        assertEquals(6,result[1]);
        ArrayList<String>arrayList1=new ArrayList<>();
        arrayList1.add("Mahmoud");
        arrayList1.add("trthy");
        arrayList1.add("tytyty");
        result=x.batchDelete(arrayList1);
        assertEquals(2,result[0]);
        assertEquals(1,result[1]);
        assertFalse(x.search("tytyty"));
        assertTrue(x.search("koko"));
    }

    @Test
    void Float_insertion_searching()
    {
        NSpace<Float>x=new NSpace<>(32,12);
        assertTrue(x.insert(13.5F));
        assertTrue(x.insert(14.5F));
        assertTrue( x.insert(0.5554F));
        assertTrue( x.insert(0.1457F));
        assertTrue( x.insert(10.0F));
        assertTrue(x.search(0.5554F));
        assertFalse(x.search(0.5F));
    }

    @Test
    void Float_deletion_searching()
    {
        NSpace<Float>x=new NSpace<>(32,12);
        assertFalse(x.delete(0.5F));
        assertFalse(x.search(0.44F));
        assertTrue(x.insert(13.5F));
        assertTrue(x.insert(11.5F));
        assertTrue( x.insert(0.55334F));
        assertTrue( x.insert(0.9457F));
        assertTrue( x.insert(11.0F));
        assertFalse(x.insert(11.0F));
        assertTrue(x.search(0.55334F));
        assertTrue(x.insert(0.44F));
        assertTrue(x.delete(0.44F));
        assertFalse(x.search(0.44F));
    }
    @Test
    void Double_test()
    {
        NSpace<Double>x=new NSpace<>(64,15);
        assertTrue(x.insert(6.785));
        assertTrue(x.insert(7.905));
        assertTrue(x.insert(-1.666));
        assertTrue(x.insert(6.777));
        assertTrue(x.delete(-1.666));
        assertTrue(x.search(7.905));
        assertFalse(x.search(-1.666));
    }
}