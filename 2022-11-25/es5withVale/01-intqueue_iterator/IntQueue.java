import java.lang.StringBuilder;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class IntQueue{
//OVERVIEW
//Le istanze sono mutabili

//AF RI
//CAMPI
  private int head, tail;
  private int[] elements;
  private boolean modified;

  //COSTRUTTORI
  //EFFECTS: costruisce una coda di dimensione n. Solleva un'eccezione di tipo IllegalArgumentException se n<=0
  public IntQueue(int n) throws IllegalArgumentException{
    if (n<=0) throw new IllegalArgumentException("Impossibile...");
    elements=new int[n];
    head=-1;
    tail=0;
    assert repOk();
  }

  //MODIFIES: this
  //EFFECTS: aggiunge l'elemento in coda a this se la coda non è piena, altrimenti solleva un'eccezione di tipo FullQueueException
  // this=[x1, x2, ..., xk], this_post= [x1, x2, ..., xk, n]
  public void enqueue(int n) throws FullQueueException{
    if (isFull()) throw new FullQueueException("Impossibile inserire elemento. Coda piena.");
    if (isEmpty()) head=0;
    elements[tail]=n;
    tail=(tail+1)%elements.length;
    modified=true;
  }
  //MODIFIES: this
  //EFFECTS: restituisce l'elemento n in testa alla coda e lo elimina da this se la coda non è vuota, altrimenti solleva un'eccezione EmptyQueueException
  // this=[x1, x2, ..., xk], this_post= [x2, ..., xk]
  public int dequeue() throws EmptyQueueException{
    if (isEmpty()) throw new EmptyQueueException("Impossibile estrarre elemento. Coda vuota");
    int result = elements[head];
    head=(head+1)%elements.length;

    if (head==tail){
      head=-1;
      tail=0;
    }
    assert repOk();
    modified=true;
    return result;
  }

  //EFFECTS: restituisce il numero di elementi della coda
  public int size(){
    return (tail - head+elements.length)%elements.length;
  }
  //EFFECTS: restituisce true se la coda è vuota, false altrimenti
  public boolean isEmpty(){
    return head==-1;
  }
  //EFFECTS: restituisce true se la coda è piena, false altrimenti
  public boolean isFull(){
    return head==tail;
  }

  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder("IntQueue: [");
    if (size()>0){
      int i;
      for (i=0 ;i<size() ; i++ ) {
        sb.append(elements[(head+i)%elements.length]+", ");
      }
      sb.append(elements[(head+i)%elements.length]);
    }
    sb.append(']');
    sb.append(" capienza massima: "+ elements.length);
    return sb.toString();
  }

  @Override
  public boolean equals(Object o){
    if (!(o instanceof IntQueue)) return false;
    IntQueue other = (IntQueue) o;
    if (elements.length != other.elements.length) return false;
    if (size()!=other.size()) return false;
    for (int i = 0; i<size() ;i++ ) {
      if (elements[(head+i)%elements.length]!=other.elements[(other.head+i)%other.elements.length]){
        return false;
      }
    }
    return true;
  }

  @Override
  public int hashCode(){
    int result = Integer.hashCode(elements.length);
    for (int i =0;i<size() ;i++ ) {
      result = 31 * result + Integer.hashCode(elements[head+i]%elements.length);
      //scelgo 31 perchè è numero primo, non divisibile per 2, scelgo primo un po' più grande così ho valori
    }
    return result;
  }

  //Controlla che RI sia valida, ovvero che la coda non contenga più elementi della sua capienza massima, tutti indici devono essere corretti
  private boolean repOk(){
    return -1<=head && head < elements.length
    && 0<= tail && tail < elements.length
    && head!=-1 || tail==0;
  }
  
  public Iterator<Integer> iterator(){
    modified=false;
    return new Iterator<Integer>(){
      int nextIndex = head;
      boolean hasNext = isFull();

      @Override
      public boolean hasNext() {
        if (!hasNext){
          hasNext=nextIndex>-1 && nextIndex!=tail;
        }
        return hasNext;
      }

      @Override
      public Integer next() throws ConcurrentModificationException, NoSuchElementException {
        if (modified) throw new ConcurrentModificationException("Coda modificata durante la lettura");
        if (!hasNext) throw new NoSuchElementException("Non ci sono più elementi da leggere");
        int res=nextIndex;
        nextIndex= (nextIndex+1)%elements.length;
        hasNext=false;
        return elements[res];
      }

    };
    
  }
}
