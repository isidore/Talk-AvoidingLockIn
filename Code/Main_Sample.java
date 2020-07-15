 public static void main(String[] args) throws Exception {

    String inputPort = null;
    String outputPort = null;

    int i = 0;
    LongOpt[] longopts = new LongOpt[6];
    longopts[i++] = new LongOpt("output", LongOpt.REQUIRED_ARGUMENT, null, 'o');
    longopts[i++] = new LongOpt("input", LongOpt.REQUIRED_ARGUMENT, null, 'i');
    Getopt g = new Getopt("Qualm", args, "o:i:", longopts);

    int c;
    while ((c = g.getopt()) != -1) {
      switch(c)
	{
	case 'i':
	  inputPort = g.getOptarg();
	  break;
	case 'o':
	  outputPort = g.getOptarg();
	  break;
	}
    }


    if (g.getOptind() == args.length) {
      System.out.println("No filename given.");
      System.exit(0);
    }
    String inputFilename = args[g.getOptind()];

    QData data = new QDataLoader().load(inputFilename);
    
    // Set up MIDI ports
    Properties props = new Properties();
    props.setProperty("inputPort", inputPort);
    props.setProperty("outputPort", outputPort);
    midiOut = new JavaMidiReceiverFactory().buildFromProperties(props);
    midiIn = midiOut;

    loopThroughPatches(data);
    System.exit(0);
  }

   public static void main(String[] args) throws Exception {

    
    new PlayAllPatches().start(loadOption(args));
   }
   public static void main(String[] args) throws Exception {

    int i = 0;
    LongOpt[] longopts = new LongOpt[6];
    longopts[i++] = new LongOpt("output", LongOpt.REQUIRED_ARGUMENT, null, 'o');
    longopts[i++] = new LongOpt("input", LongOpt.REQUIRED_ARGUMENT, null, 'i');
    Getopt g = new Getopt("Qualm", args, "o:i:", longopts);
    new PlayAllPatches().start(g);
   }

    public void start(Getopt g){

    String inputPort = null;
    String outputPort = null;
    int c;
    while ((c = g.getopt()) != -1) {
      switch(c)
	{
	case 'i':
	  inputPort = g.getOptarg();
	  break;
	case 'o':
	  outputPort = g.getOptarg();
	  break;
	}
    }


    if (g.getOptind() == args.length) {
      System.out.println("No filename given.");
      System.exit(0);
    }
    String inputFilename = args[g.getOptind()];

    QData data = new QDataLoader().load(inputFilename);
    
    // Set up MIDI ports
    Properties props = new Properties();
    props.setProperty("inputPort", inputPort);
    props.setProperty("outputPort", outputPort);
    midiOut = new JavaMidiReceiverFactory().buildFromProperties(props);
    midiIn = midiOut;

    loopThroughPatches(data);
    System.exit(0);
  }