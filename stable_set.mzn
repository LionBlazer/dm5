include "globals.mzn";

int: n;

array[1..n, 1..n] of int: adj_matrix;

array[1..n] of var 0..1: nodes_in_set;

constraint forall(i, j in 1..n where i < j) (
    (nodes_in_set[i] + nodes_in_set[j]) <= 1 \/ adj_matrix[i, j] = 0
);

var int: set_size = sum(nodes_in_set);
solve maximize set_size;

output ["Maximum stable set size: ", show(set_size), "\n"] ++
["Nodes in the set: "] ++ [show(i) ++ " " | i in 1..n where fix(nodes_in_set[i]) == 1];
