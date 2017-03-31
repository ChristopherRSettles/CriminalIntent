package com.bignerdranch.android.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Chris on 3/21/2017.
 */

public class CrimeLab {
    private static CrimeLab sCrimeLab;

    private List<Crime> mCrimes;

    public static CrimeLab get(Context context){
        if(sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context){
        mCrimes = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            Crime crime = new Crime();
            crime.setSolved((i%2 == 0));
            crime.setTitle("Crime #" + i);
            mCrimes.add(crime);
        }
    }

    public List<Crime> getCrimes(){
        return mCrimes;
    }

    public Crime getCrime(UUID crimeId){
        for(int i = 0; i < mCrimes.size(); i++){
            if (mCrimes.get(i).getID().equals(crimeId)){
                return mCrimes.get(i);
            }
        }

        return null;
    }
}
