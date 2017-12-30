function shuffle(array) {
  var currentIndex = array.length, temporaryValue, randomIndex;
  while (0 !== currentIndex) {
    randomIndex = Math.floor(Math.random() * currentIndex);
    currentIndex -= 1;
    temporaryValue = array[currentIndex];
    array[currentIndex] = array[randomIndex];
    array[randomIndex] = temporaryValue;
  }
  return array;
}

pot_a = [["Russia", 0], ["Germany", 0], ["Brazil", 2], ["Portugal", 0], ["Argentina", 2], ["Belgium", 0], ["Poland", 0], ["France", 0]];
pot_b = [["Spain", 0], ["Peru", 2], ["Switzerland", 0], ["England", 0], ["Colombia", 2], ["Mexico", 4], ["Uruguay", 2], ["Croatia", 0]];
pot_c = [["Denmark", 0], ["Iceland", 0], ["Costa Rica", 4], ["Sweden", 0], ["Tunisia", 3], ["Egypt", 3], ["Senegal", 3], ["Iran", 1]];
pot_d = [["Serbia", 0], ["Nigeria", 3], ["Australia", 1], ["Japan", 1], ["Morocco", 3], ["Panama", 4], ["South Korea", 1], ["Saudi Arabia", 1]];

var pa = [], pb = [], pc = [], pd = [];
var rpb = [[]], rpc = [[]], rpd = [[]];

var s17 = pot_a.slice(1, 8);
s17 = shuffle(s17);
s17.unshift(pot_a[0]);

pot_a = s17;

for(j=0; j<8; j++) {
	pa[j] = pot_a[j][1];
}	

retry = true;

while (retry) {
	var x = shuffle(pot_b);
	retry = false;
	for(j=0; j<8; j++) {
		pb[j] = x[j][1];
		if (pa[j]==2 && pb[j]==2) retry = true;
	}	
}	

rpb = x;
retry = true;

while (retry) {
	var x = shuffle(pot_c);
	retry = false;
	for(j=0; j<8; j++) {
		pc[j] = x[j][1];
		if (pa[j]==0 && pb[j]==0 && pc[j]==0) retry = true;
		for (p=1; p<5; p++) {
			if (pa[j]==p && pb[j]==p) retry = true;
			if (pa[j]==p && pc[j]==p) retry = true;
			if (pb[j]==p && pc[j]==p) retry = true;
		}
	}	
}	

rpc = x;
retry = true;

while (retry) {
	var x = shuffle(pot_d);
	retry = false;
	for(j=0; j<8; j++) {
		pd[j] = x[j][1];
		if (pa[j]==0 && pb[j]==0 && pc[j]==0) retry = true;
		if (pa[j]==0 && pb[j]==0 && pd[j]==0) retry = true;
		if (pa[j]==0 && pc[j]==0 && pd[j]==0) retry = true;
		if (pb[j]==0 && pc[j]==0 && pd[j]==0) retry = true;
		for (p=1; p<5; p++) {
			if (pa[j]==p && pb[j]==p) retry = true;
			if (pa[j]==p && pc[j]==p) retry = true;
			if (pa[j]==p && pd[j]==p) retry = true;
			if (pb[j]==p && pc[j]==p) retry = true;
			if (pb[j]==p && pd[j]==p) retry = true;
			if (pc[j]==p && pd[j]==p) retry = true;
		}
	}	
}	

rpd = x;

var group = [];

for (k=0; k<8; k++) {
	group[k] = [pot_a[k][0], shuffle([rpb[k][0], rpc[k][0], rpd[k][0]])];
	console.log(group[k]);
}

