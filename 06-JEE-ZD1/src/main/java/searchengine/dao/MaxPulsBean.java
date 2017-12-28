package searchengine.dao;

import searchengine.domain.Gender;

import javax.enterprise.context.RequestScoped;

import static searchengine.domain.Gender.MEN;
import static searchengine.domain.Gender.WOMEN;
@RequestScoped
public class MaxPulsBean implements MaxPlus{
    @Override
    public double puls(int in, Gender gender) {
        if(gender==MEN){

            return 202-(0.55*in);
        }
        if(gender==WOMEN){
            return 216-(1.09*in);
        }
    return 0;
    }
}
