package grafos;

public class MatrizAdy {
  private int matriz[][];
  private int grados[];

  public MatrizAdy(int size) {
    matriz = new int[size - 1][];
    grados = new int[size];
    for (int i = 0; i < size -1; i++) {
      matriz[i] = new int[size - i - 1];
    }
  }
  
  public void agregar(int a, int b, int costo) {
    if (a == b)
      return;
    if (a > b) {
      agregar(b, a, costo);
      return;
    }
    matriz[a][b -a -1] = costo;
    grados[a]++;
    grados[b]++;
  }
  
  public void agregar(int a, int b) {
    agregar(a, b, 1);
  }
  
  public int getValue(int a, int b) {
    if(a == b)
      return 0;
    if (a > b)
      return getValue(b, a);
    return matriz[a][b -a -1];
  }
  
  public int getGrado(int a) {
    return grados[a];
  }
  public int getMenorGrado() {
    int menor = grados[0];
    for(int i = 1 ; i < grados.length ; i++) {
      if (grados[i] < menor)
        menor = grados[i];
    }
    return menor;
  }
  
  public int getMaxGrado() {
    int mayor = grados[0];
    for(int i = 1; i < grados.length; i++) {
      if(grados[i] > mayor)
        mayor = grados[i];
    }
    return mayor;
  }
  
  public String toString() {
    String out = "   ";
    for(int i = 1 ; i <= matriz.length; i++)
      out += i + "\t";
    out += "\n\n";
    for(int i = 0 ; i < matriz.length ; i ++) {
      out += i + "  ";
      for(int k = 0; k < i; k++)
        out += "\t";
      for(int j = 0 ; j < matriz[i].length ; j++) {
        out += matriz[i][j] + "\t";
      }
      out += "\n";
    }
    return out;
  }
}
