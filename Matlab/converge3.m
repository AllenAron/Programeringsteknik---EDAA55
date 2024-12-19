function result = converge3(z, c)
k=0;

while abs(z)<2 && k<100;
    z=z.^2+c;
    k=k+1;
end
result = k;
end