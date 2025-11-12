package oop.adt;

/**
 * Rozhraní definující základní operace zásobníku pro řetězce (String).
 * Zásobník je datová struktura typu LIFO (Last In, First Out),
 * kde je poslední vložená hodnota zároveň první odebraná.
 *
 * <h5>Využití</h5>
 * <ol>
 *  <li> Historie prohlížeče </li>
 *  <li> Párování závorek, tagů </li>
 *  <li> Undo/Redo </li>
 *  <li> Zpracování cesty </li>
 *  <li> Odstranění rekurze </li>
 * </ol>
 */
public interface MyStack {
    /**
     * Vloží řetězec na vrchol zásobníku.
     *
     * @param value hodnota, která má být vložena
     */
    void push(String value);

    /**
     * Odebere a vrátí hodnotu z vrcholu zásobníku.
     * Pokud je zásobník prázdný, metoda vypíše na konzoli "Empty Stack" a vrátí null.
     *
     * @return hodnota z vrcholu zásobníku
     */
    String pop();

    /**
     * Vrátí hodnotu z vrcholu zásobníku, aniž by ji odstranila.
     * Pokud je zásobník prázdný, metoda vypíše na konzoli "Empty Stack" a vrátí null.
     *
     * @return hodnota z vrcholu zásobníku
     */
    String peek();

    /**
     * Zjišťuje, zda je zásobník prázdný.
     *
     * @return true, pokud zásobník neobsahuje žádné prvky, jinak false
     */
    boolean isEmpty();

    /**
     * Vrátí počet hodnot aktuálně uložených v zásobníku.
     *
     * @return velikost zásobníku
     */
    int size();
}
