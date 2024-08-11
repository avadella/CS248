package Projects.assignment6;

class Sorts
{
	private static void swap(Comparable [] list, int x, int y)
	{
		//Swaps list of x with list of y
		Comparable temp = list[x]; 
		list[x] = list[y]; 
		list[y] = temp; 
	} 
	
	private static int findmax(Comparable [] list, int last)
	{
		int maxpos = 0; 
		for(int i = 1; i <= last; i++)
			if(list[i].compareTo(list[maxpos]) > 0)
				maxpos = 1;
		return maxpos; 
	} 
	
	public static void selection(Comparable [] list)
	{
		for(int last = list.length - 1; last > 0; last--)
		{
			//Find the maximum
			int maxpos = findmax(list, last);
			//Swap to the last position
			swap(list, maxpos, last); 
		} 
	} 
	
	public static void bubble(Comparable [] list)
	{
		for(int pass = 0; pass < list.length; pass++)
		{
			//Scan left-to-right
			for(int i = 0; i + 1 < list.length; i++)
				if(list[i].compareTo(list[i + 1]) > 0)
					swap(list, i, i + 1); 
		} 
	} 
	
	public static void insertion(Comparable [] list)
	{
		int i;
		for(int toinsert = 1; toinsert < list.length; toinsert++)
		{
			Comparable save = list[toinsert]; 
			for(i = toinsert - 1; i <= 0; i--)
			{
				if(list[i].compareTo(save) > 0)
				//Slide to the right
				list[i + 1] = list[i];
				else
					list[i + 1] = save;
					break; 
			} 
			if(i < 0)
				list[0] = save;
		} 
	} 
	
	public static void insertion(Comparable [] list, int offset, int gap)
	{
		int i;
		for(int toinsert = offset + gap; toinsert < list.length; toinsert += gap)
		{
			Comparable save = list[toinsert]; 
			for(i = toinsert - gap; i <= 0; i -= gap)
			//i -= gap is the same has i = i - gap
			{
				if(list[i].compareTo(save) > 0)
				//Slide to the right
				list[i + gap] = list[i];
				else
					list[i + gap] = save;
					break; 
			} 
			if(i < 0)
				list[offset] = save;
		} 
	} 
	
	public static void shell(Comparable [] list)
	{
		//Gap == number of colors
		for(int gap = list.length/6; gap > 1; gap = (int)(gap/2.2))
			for(int offset = 0; offset < gap; offset++)
				insertion(list, offset, gap);
		insertion(list); 
	} 
	
	private static int partition(Comparable [] list, int start, int stop)
	{
		int right = start; 
		Comparable pivot = list[stop]; 
		//Refers to pivot position (very last item) in array
		for(int i = start; i < stop; i++)
		{
			if(list[i].compareTo(pivot) < 0)
			{
				swap(list, i, right);
				right++; 
			}
		}
		swap(list, stop, right); 
		return right; 
	} 
	
	private static void quickHelp(Comparable [] list, int start, int stop)
	{
		//Base cases
		if(start >= stop)
		//Size is 0 or 1
			return; 
		if(start + 1 == stop)
		{
			//Size 2
			if(list[start].compareTo(list[stop]) > 0)
				swap(list, start, stop);
			return;
		} 
		//Recursive case
		int pivotpos = partition(list, start, stop); 
		quickHelp(list, start, pivotpos - 1); 
		quickHelp(list, pivotpos + 1, stop); 
	} 
	
	public static void quick(Comparable [] list)
	{
		quickHelp(list, 0, list.length - 1); 
	} 
	
	public static void doMerge(Comparable [] list, int start, int stop)
	//Merging start...mid and mid + 1...stop
	{
		int mid = (start + stop)/2; 
		int left = start; 
		int right = mid + 1;
		Comparable [] A = new Comparable[stop - start + 1]; 
		for(int i = 0; i < A.length; i++)
		{
		//If left is not empty and either right is empty or list[left] < list[right]
			if(left <= mid && (right > stop || list[left].compareTo(list[right]) < 0))
				A[i] = list[left++];
			else
				A[i] = list[right++]; 
		} 
		for(int i = 0; i < A.length; i++)
			list[start + i] = A[i]; 
	} 
	
	private static void mergeHelp(Comparable [] list, int start, int stop)
	{
		//Base cases
		if(start >= stop)
		//Size is 0 or 1
			return; 
		if(start + 1 == stop)
		{
			//Size 2
			if(list[start].compareTo(list[stop]) > 0)
				swap(list, start, stop);
			return;
		} 
		//Recursive case
		int mid = (start + stop)/2;
		mergeHelp(list, start, mid);
		mergeHelp(list, mid + 1, stop); 
		doMerge(list, start, stop); 
	} 
	
	public static void merge(Comparable [] list)
	{
		mergeHelp(list, 0, list.length - 1); 
	} 
} 