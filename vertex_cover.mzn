include "globals.mzn";

int: n;
array[1..n, 1..n] of 0..1: adj_matrix;

array[1..n] of var 0..1: vertex_cover;

var int: total_covered = sum(vertex_cover);
solve minimize total_covered;

constraint forall(i, j in 1..n where adj_matrix[i, j] == 1)(
vertex_cover[i] + vertex_cover[j] >= 1
);

output ["Minimum vertex cover size: ", show(total_covered), "\n"] ++
["Cover: ", show(array1d(1..n, [if vertex_cover[i] == 1 then i else 0 endif | i in 1..n])), "\n"];