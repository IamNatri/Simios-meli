```
curl -i -X POST http://localhost:8080/simian -H "Content-Type: application/json" -d '{"dna":["CCCCAT","TTATGC","AATTGT","GCAGTG","CACATA","CCACTG"]}'

curl -i -X POST http://localhost:8080/simian -H "Content-Type: application/json" -d '{"dna":["CTGATA",ACATGC","GACTGT","AAACGG","CCTACA","ATCCTC"]}'

curl -i -X POST http://localhost:8080/simian -H "Content-Type: application/json" -d '{"dna":["CTGATA","CTATGC","CATTGT","CCAGGG","CCCATA","CCCCTG"]}'
//4x4 
curl -X POST http://localhost:8080/simian -H "Content-Type: application/json" -d '{"dna":["ATGC","ATGC","ATGC","CCCC"]}'

//empty
curl -X POST http://localhost:8080/simian -H "Content-Type: application/json" -d '{"dna":[]}'
//error
curl -X POST http://localhost:8080/simian -H "Content-Type: application/json" -d '{"dna":["ATGZ","CTGZ","TTAX","CGTX"]}'


```