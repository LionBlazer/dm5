include "globals.mzn";

int: n;
array[1..n, 1..n] of int: adj_matrix;

var int: k;
constraint k <= 43 /\ k > 2;

array[1..43] of var 1..n: succ;


constraint succ[1] = succ[k];

constraint forall(i in 1..(k - 1)) (adj_matrix[succ[i], succ[i + 1]] = 1);

constraint forall(i in 1..n) (
  exists(j in 1..k) (
    succ[j] = i
  )
);


solve minimize k;

output ["Shortest closed walk: " ++ show(succ) ++ "\nTotal distance: " ++ show(k)];