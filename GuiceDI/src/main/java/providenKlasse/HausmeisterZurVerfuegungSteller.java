package providenKlasse;

import com.google.inject.Provider;

class HausmeisterZurVerfuegungSteller implements Provider<Hausmeister>{

   public Hausmeister get() {
      return new HausmeisterImpl("Karl", 42);
   }
}
