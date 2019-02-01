#include <iostream>
#include <stdlib.h>
#include <cmath>
using namespace std;

double simulatePi(int darts)
{
	srand(time(NULL));
	double numIn, numTotal, x, y;
	for(int i = 0; i < darts; i++)
	{
		x = ((double) rand() / (double)(RAND_MAX)) - 0.5;
		y = ((double) rand() / (double)(RAND_MAX)) - 0.5;
		double dist = sqrt((x*x) + (y*y));
		if( dist <= 0.5)
		{
			numIn += 1.0;
		}

		numTotal += 1.0;
	}
	return 4.0 * numIn / numTotal;
}

int generatePi(int games, int darts)
{
	double raw[games];
	double sum = 0.0;
	double diffSum = 0.0;
	double x;
	for(int i = 0; i < games; i++)
	{
		x = simulatePi(darts);
		raw[i] = x;
		sum += x;
	}
	
	double mean = sum / (double) games;
	
	for(int i = 0; i < games; i++)
	{
		diffSum += ((raw[i] - mean) * (raw[i] - mean));
	}
	
	double sDevRaw = diffSum / (double) games;
	double sDev = sqrt(sDevRaw);
	cout << mean;
	cout << '\n';
	cout << sDev;
	cout << '\n';
	return 0;
}

int main() {
	generatePi(10, 1000000);
	return 0;
}
