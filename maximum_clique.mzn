include "globals.mzn";

int: n;
array[1..n, 1..n] of 0..1: adj_matrix;

var 0..n: max_clique_size;

array[1..n] of var 0..1: in_clique;

constraint forall(i, j in 1..n where i < j) (
(in_clique[i] = 1 /\ in_clique[j] = 1) -> (adj_matrix[i, j] = 1)
);

constraint sum(in_clique) = max_clique_size;

solve maximize max_clique_size;

output ["Maximum clique size: ", show(max_clique_size), "\n"]