#!/usr/bin/perl


local ($buffer, @pairs, $pair, $name, $value, %FORM);
# ��ȡ�ı���Ϣ
$ENV{'REQUEST_METHOD'} =~ tr/a-z/A-Z/;
if ($ENV{'REQUEST_METHOD'} eq "POST")
{
   read(STDIN, $buffer, $ENV{'CONTENT_LENGTH'});
}else {
   $buffer = $ENV{'QUERY_STRING'};
}
# ��ȡ name/value ����Ϣ
@pairs = split(/&/, $buffer);
foreach $pair (@pairs)
{
   ($name, $value) = split(/=/, $pair);
   $value =~ tr/+/ /;
   $value =~ s/%(..)/pack("C", hex($1))/eg;
   $FORM{$name} = $value;
}
$name = $FORM{name};
$site  = $FORM{site};
$totle=0;
print "Content-type:text/html\r\n\r\n";
print "<html>";
print "<head>";
print '<meta charset="utf-8">';
print '<title>Lab 8-9</title>';
print "</head>";
print "<body>";
print "<h2>�˿���:$name</h2>";
print "<h2>֧����ʽ$site</h2>";
print "<h2>������:</h2>";
if( $FORM{cb1} ){
  print "<h2>Four 100-watt light bulbs for $2.39</h2>";
  $totle= $totle+2.39*(1+0.062);
}
if( $FORM{cb2} ){
  print "<h2>Eight 100-watt light bulbs for $4.29</h2>";
  $totle= $totle+4.29*(1+0.062);
}
if( $FORM{cb3} ){
  print "<h2>Four 100-watt long-life light bulbs for $3.95</h2>";
  $totle= $totle+3.95*(1+0.062);
}
if( $FORM{cb4} ){
  print "<h2>Eight 100-watt long-life light bulbs for $7.49</h2>";
  $totle= $totle+7.49*(1+0.062);
}
 print "<h2>˰�պ���ܼ�Ϊ:$totle</h2>";
print "</body>";
print "</html>";