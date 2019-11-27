package collections_generics.uebung_Generics;

import java.util.ArrayList;

public class MySortedList<T extends Comparable<? super T>> extends ArrayList<T>{

    @Override
    public boolean add(T e){
        if(this.isEmpty()){
            super.add(e);
            return true;
        }
        int counter =0;
        for(T t : this){
            if(e.compareTo(t)<0){
                super.add(counter,e);
                return true;
            }
            counter++;
        }
        super.add(e);
        return true;
    }

    public boolean elementChanged(T e){
        int counter =0;
        for(T t : this){
            if(e.compareTo(t) == 0){
                super.remove(counter);
                break;
            }
            counter++;
        }
        this.add(e);
        return true;
    }

    public int findIndex(T t, int von, int bis){
        if(this.isEmpty()){
            return 0;
        }

        while(von <= bis){
            System.out.println("Von :" + von + " Bis : "+ bis);
            int mid = (von+bis)/2;
            if(t.compareTo(this.get(mid))>0){
                bis = mid -1;
            }else{
                von = mid+1;
            }
        }
        if(t.compareTo(this.get(von-1))==0){
            return bis-1;
        }
        return -1;
    }
}
