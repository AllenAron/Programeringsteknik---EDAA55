function result = converge2(z)
k=0;
c=z;
while abs(z)<2 && k<100;
    z=z*z+c;
    k=k+1;
end
result = k;
end

