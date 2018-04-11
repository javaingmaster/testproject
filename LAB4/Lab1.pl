open(_filename,"<D:/in.txt") or die "in.txt notexist,$!";
@lines =<_filename>;
close(_filename) || die "cannot close";
foreach(@lines){
    $_=lc($_);
}
my $lines = join('', @lines);
my %words;
while ($lines =~ m#\b(\w+)\b#smg){
	if (not exists $words{$1}){
		$words{$1} = 1;
	}
	else{
		$words{$1}++;
	}
}
foreach $key(sort keys %words)  {  
	printf "%-20s %3d\n",$key,$words{$key};  
} 

