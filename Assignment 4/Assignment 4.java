class HashTable {
    private Entry[] table;
    private int tableSize;
    private int numItems;
    private double loadFactor;
    // maximum load before needing to refactor
    private double maxLoad = 0.75;
    
    private class Entry{
        private String word;
        // the next item (because of chaining)
        private Entry next;
        int occurs;

        private Entry(String word) {
            this.word = word;
            next = null;
            // number of occurences of the word
            occurs = 1;
        }
    }

    // gets the hash code for a word
    private int hash(String s) {
        return Math.abs(s.hashCode()) % tableSize;
    }
   
    public HashTable() {
        // start with size of 10
        int size = 10;
        table = new Entry[size];
        tableSize = size;
        numItems = 0;
        loadFactor = 0;
    }

    public void insert(String s) {
        Entry toInsert;
        // remove all apostrophes because they mess up the count
        s = s.replace("'", "");
        // split string into seperate words as provided in instructions
        String[] words = s.split("\\P{Alpha}+");

        for(String word : words) {
            // capitals do not matter
            toInsert = new Entry(word.toLowerCase());
            insertHelper(toInsert);
        }
    }

    // helper method for add
    public void insertHelper(Entry entry) {
        int key = hash(entry.word);

        // when key does not exist in table
        if(table[key] == null) {
            numItems++;
            table[key] = entry;
            // update load factor after adding and expand table if necessary
            updateLoadFactor();
            return;
        }
        // when word is already present at the index key
        if(table[key].word.hashCode() == entry.word.hashCode() ) {
            // just increase count
            table[key].occurs++;
            numItems++;
            updateLoadFactor();
            return;
        }

        // when index is occupied but word is not found
        Entry trav = table[key];
        while(trav.next != null) {
            if(trav.word.hashCode() == entry.word.hashCode()) {
                trav.occurs++;
                numItems++;
                updateLoadFactor();
                return;
            }

            trav = trav.next;
        }

        // when word does not exist in table
        trav.next = entry;
        numItems++;
        updateLoadFactor();
    }

    // helper method to rehash the table when the size needs to be updated
    // calculates the new hash codes for all entries and puts them in a new table
    public void rehash() {
        int oldSize = tableSize;
        Entry[] oldTable = table;

        // new table double the old size
        tableSize = 2 * oldSize;
        table = new Entry[tableSize];

        // move the entries over
        for(int i=0; i<oldSize; i++) {
            if(oldTable[i] != null) {
                // traverse through all words at each hash code
                Entry trav = oldTable[i];

                while(trav != null) {
                    // add each occurrence of the word
                    for(int j=0; j<trav.occurs; j++){
                        // use helper because there is no need to split string
                        insert(trav.word);
                    }
                    
                    trav = trav.next;
                }
            }
        }
    }

    public void updateLoadFactor() {
        // calculate new load factor
        loadFactor = ((double)numItems) / ((double)tableSize);

        // when load factor is too high expand table and rehash
        if(loadFactor > maxLoad)
            rehash();
    }
    
    public void print() {
        // print out basic stats of table
        System.out.println("Table size: " + tableSize);
        System.out.println("Number of items: " + numItems);
        System.out.println("Load factor: " + loadFactor);

        // traverse table
        for(int i=0; i<table.length; i++) {
            if(table[i] != null) {
                Entry trav = table[i];

                while(trav != null) {
                    System.out.println(trav.word + ": " + trav.occurs);
                    trav = trav.next;
                }
            }
        }
    }

    public void wordCount(String words) {
        HashTable toCount = new HashTable();
        toCount.insert(words);
        toCount.print();
    }
}

class Test {
    public static void main(String[] args) {
        HashTable words = new HashTable();
        words.wordCount("MF DOOM - Meat Grinder - Sleeping in a jar! Sleeping in a jar! The jar is under the bed Sleeping in a jar! The jar is under the bed Tripping off the beat kinda, dripping off the meat grinder Heat niner, pimping, stripping, soft sweet minor China was a neat signer, trouble with the script digits Double dipped, bubble lipped, subtle lisp midget Borderline schizo, sort of fine tits though Pour the wine, whore to grind, quarter to nine, let's go Ever since ten eleven, glad she made a brethren Then it's last down, seven alligator seven At the gates of heaven, knocking - no answer Slow dancer, hopeless romancer, dopest flow stanzas Yes, no? Villain, Metal face to Destro Guess so, still incredible in escrow Just say Ho! I'll test the yayo Wild West style fest, y'all best to lay low Hey bro, Day Glo, set the bet, pay dough Before the cheddar get away, best to get Maaco The worst hated God who perpetrated odd favors Demonstrated in the perforated Rod Lavers In all quad flavors, Lord save us Still back in the game like Jack LaLanne Think you know the name, don't rack your brain On a fast track to half insane Either in a slow beat or that the speed of 'Wrath of Kane' Laughter, pain Hackthoo'ing songs lit, in the booth, with the best host Doing bong hits, on the roof in the west coast He's at it again, mad at the pen Glad that we win a tad fat, in a bad hat for men Grind the cinnamon, Manhattan warmongers You can find the villain in satin, kongas The van screeches The old man preaches about the gold sand beaches The cold hand reaches for the old tan Ellesse's Jesus ");
    }
}