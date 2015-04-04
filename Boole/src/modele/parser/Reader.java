/* Generated By:JavaCC: Do not edit this line. Reader.java */
package modele.parser;

import modele.circuit.Ouvert;
import modele.*;
import modele.composant.*;

public class Reader implements ReaderConstants {
  public static void main(String args []) throws ParseException
  {
    Reader parser = new Reader(System.in);
    boolean yes = true;
    while (yes)
    {
      System.out.println("Reading from standard input...");
      System.out.print("Enter an expression like \u005c"1+(2+3)*4;\u005c" :");
      try
      {

       /*_Circuit cir;
       List<_Composant> lComposite= new LinkedList<_Composant>();*/
        switch (Reader.one_line())
        {
          case 0 :
          System.out.println("OK.");
          break;
          case 1 :
          System.out.println("Goodbye.");
          yes = false;
          break;
          default :
          break;
        }
      }
      catch (Exception e)
      {
        System.out.println("NOK.");
        System.out.println(e.getMessage());
        Reader.ReInit(System.in);
      }
      catch (Error e)
      {
        System.out.println("Oops.");
        System.out.println(e.getMessage());
        break;
      }
    }
  }

/*Lit un fichier de circuit de la manière suivante :
  Lit O..* Composites
  Lit un circuit.
  Renvoie un circuit*/
  static final public int one_line() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CIRCUIT:
    case COMPOSITE:
      label_1:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMPOSITE:
          ;
          break;
        default:
          jj_la1[0] = jj_gen;
          break label_1;
        }
        composite();
      }
      jj_consume_token(CIRCUIT);
      circuit();
      jj_consume_token(16);
                                         {if (true) return 0;}
      break;
    case 16:
      jj_consume_token(16);
       {if (true) return 1;}
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public void composite() throws ParseException {
    jj_consume_token(COMPOSITE);
    composite2();

  }

  static final public void composite2() throws ParseException {
    jj_consume_token(NOM);
    jj_consume_token(17);
    jj_consume_token(NUM);
    jj_consume_token(18);
    jj_consume_token(NUM);
    jj_consume_token(19);
    label_2:
    while (true) {
      composant();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 26:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
    }
    specif();

  }

  static final public void specif() throws ParseException {
    jj_consume_token(20);
    label_3:
    while (true) {
      composEntree();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 22:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_3;
      }
    }
    jj_consume_token(21);
    label_4:
    while (true) {
      composSortie();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 22:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_4;
      }
    }
  }

  static final public void composEntree() throws ParseException {
    jj_consume_token(22);
    jj_consume_token(ENTREE);
    jj_consume_token(17);
    jj_consume_token(NUM);
    jj_consume_token(22);
    jj_consume_token(NUM);
    jj_consume_token(19);
    composEntree2();

  }

  static final public void composEntree2() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 21:
      jj_consume_token(21);
      break;
    case 23:
      jj_consume_token(23);
      jj_consume_token(22);
      jj_consume_token(ENTREE);
      jj_consume_token(17);
      jj_consume_token(NUM);
      jj_consume_token(22);
      jj_consume_token(NUM);
      jj_consume_token(19);
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void composSortie() throws ParseException {
    jj_consume_token(22);
    jj_consume_token(SORTIE);
    jj_consume_token(17);
    jj_consume_token(NUM);
    jj_consume_token(22);
    jj_consume_token(NUM);
    jj_consume_token(19);
    composSortie2();

  }

  static final public void composSortie2() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 24:
      jj_consume_token(24);
      break;
    case 25:
      jj_consume_token(25);
      jj_consume_token(SORTIE);
      jj_consume_token(17);
      jj_consume_token(NUM);
      jj_consume_token(22);
      jj_consume_token(NUM);
      jj_consume_token(19);
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*Lit le nom, le passe à la lecture des composants*/
  static final public void circuit() throws ParseException {
    jj_consume_token(NOM);
    label_5:
    while (true) {
      composant();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 26:
        ;
        break;
      default:
        jj_la1[7] = jj_gen;
        break label_5;
      }
    }

  }

  static final public void composant() throws ParseException {
    jj_consume_token(26);
    jj_consume_token(NUM);
    jj_consume_token(27);
    jj_consume_token(NOM);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 17:
      jj_consume_token(17);
      jj_consume_token(NUM);
      jj_consume_token(18);
      jj_consume_token(NUM);
      jj_consume_token(19);
      break;
    default:
      jj_la1[8] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 28:
      jj_consume_token(28);
      jj_consume_token(STATE);
      jj_consume_token(29);
      break;
    default:
      jj_la1[9] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 30:
      jj_consume_token(30);
      break;
    default:
      jj_la1[10] = jj_gen;
      ;
    }
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 22:
      case 31:
        ;
        break;
      default:
        jj_la1[11] = jj_gen;
        break label_6;
      }
      sortie();
    }
  }

  static final public void sortie() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 31:
      jj_consume_token(31);
      break;
    case 22:
      jj_consume_token(22);
      jj_consume_token(NUM);
      jj_consume_token(17);
      lien();
      sortie2();
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void sortie2() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 31:
      jj_consume_token(31);
      break;
    case 32:
      jj_consume_token(32);
      jj_consume_token(NUM);
      jj_consume_token(17);
      lien();
      sortie2();
      break;
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void lien() throws ParseException {
    jj_consume_token(NUM);
    jj_consume_token(22);
    jj_consume_token(NUM);
    lien2();
  }

  static final public void lien2() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 19:
      jj_consume_token(19);
      break;
    case 18:
      jj_consume_token(18);
      jj_consume_token(NUM);
      jj_consume_token(22);
      jj_consume_token(NUM);
      lien2();
      break;
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public ReaderTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[15];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x8000,0x19000,0x4000000,0x400000,0x400000,0xa00000,0x3000000,0x4000000,0x20000,0x10000000,0x40000000,0x80400000,0x80400000,0x80000000,0xc0000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x1,0x0,};
   }

  /** Constructor with InputStream. */
  public Reader(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Reader(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ReaderTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Reader(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ReaderTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Reader(ReaderTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ReaderTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[33];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 15; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 33; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
