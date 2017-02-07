Fragment is a piece (can say sub activity) which isb used to make more modular design.

1 .Frgaments has it's own layout design and it's own life cycle.

2 . A fragment can be added to or removed from an activity while it's parent activity is running.

3 . Multiple fragments can be added to a single activity to make multipane screen.

4 . A single fragment can be added to multiple activities.

5 . Fragment life cycle is closely related to activity's life cycle. If, parent activity is stopped then all the fragments added to the 
    activity will be also stopped.
    
6 . Frgament can implement a behaviour that has no User interface.

You create fragments by extending Fragment class and You can insert a fragment
into your activity layout by declaring the fragment in the activity's layout file, as a <fragment> element.

To Add a fragment to an activity write following code.






// Declaration of variables

private FragmentManager fragmentManager;
private FragmentTransaction fragmentTransaction;

//Initialize variables.

 fragmentManager = getSupportFragmentManager();
 
 fragmentTransaction=fragmentManager.beginTransaction();
 
 YourFragment yourFragment=new YourFragment();
  fragmentTransaction.replace(R.id.fragment_container,yourFragment,"Label"); //Fragment container is view defined in your parent activity to add child fragment
  
  
  
  
  In your Fragment class now override onCreate() and onCreateView();
  
  onCreate() is the first call back when fragment created.In this call back initialize your global variables.
  
  
  
  
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
  
  
  
  
  onCreateView() is called when it becomes able to interact with the user. In this callback intialize your views.
  
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        return view;
    }



