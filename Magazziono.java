import java.util.HashMap;

/**
 * Magazziono
 */
public class Magazziono {

    private HashMap<String,Integer> magazzino = new HashMap<String,Integer>();

    public synchronized int tot(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO: handle InterruptedException
        }
        return magazzino.size();
    }

    public synchronized boolean esite(String oggetto){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO: handle InterruptedException
        }
        return magazzino.containsKey(oggetto);
    }

    public synchronized void add(String newOggetto){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO: handle InterruptedException
        }
        magazzino.put(newOggetto, 0);
        System.out.println("L'oggetto è stato aggiunto al magazzino\n");
    }

    public synchronized void enc(String oggetto,int quantit){
        if (magazzino.containsKey(oggetto)) {
            int t= magazzino.get(oggetto);
            t+=quantit;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO: handle InterruptedException
            }
            magazzino.put(oggetto, t);
        }else{
            add(oggetto);
            enc(oggetto, quantit);
        } 
    }

    public synchronized void dec(String oggetto,int quantit){
        if (magazzino.containsKey(oggetto)) {
            int t= magazzino.get(oggetto);
            t-=quantit;
            if (t<0) {
                t=0;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO: handle InterruptedException
            }
            magazzino.put(oggetto, t);
        }else{
            System.out.println("L'oggetto non si trova nel magazzino\n");
        } 
    }
}