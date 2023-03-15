include "globals.mzn";

int: n;
array[1..n, 1..n] of int: adj_matrix;

int: max_colors = n;

array[1..n] of var 1..max_colors: colors;

constraint forall(i, j in 1..n where adj_matrix[i, j] == 1) (
    colors[i] != colors[j]
);

var int: num_colors = max(colors);
solve minimize num_colors;

output [ "Minimum number of colors: \(num_colors)\n" ] ++
       [ "Colors: \(colors)\n" ];
