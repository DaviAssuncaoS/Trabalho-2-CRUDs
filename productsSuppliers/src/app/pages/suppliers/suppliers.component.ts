import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-suppliers',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './suppliers.component.html',
  styleUrl: './suppliers.component.css'
})
export class SuppliersComponent {
  private apiUrl = 'http://localhost:8080/api/v1/suppliers';

  valueProductSupplied: any;
  valueContact: any;
  valueAddress: any;
  valueName: any;
  supplier: any;
  supplierId: any;

  constructor(private http: HttpClient, private route: ActivatedRoute, private router: Router) { }

  getSupplier(supplierId: number): Observable<any[]> {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.get<any[]>(this.apiUrl + "/" + supplierId, { headers });
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.supplierId = params['supplierId'];
      console.log(this.supplierId);
      this.getSupplier(this.supplierId).subscribe(
        (response: any) => {
          console.log(response);
          this.supplier = response.data;
          this.valueName = this.supplier.name;
          this.valueAddress = this.supplier.address;
          this.valueContact = this.supplier.contact;
          this.valueProductSupplied = this.supplier.productSupplied;
        },
        (error) => {
          console.error('Erro ao carregar fornecedor:', error);
        }
      );
    });
  }

  async sendSupplier(): Promise<void> {

    console.log(this.valueName);
    console.log(this.valueAddress);
    console.log(this.valueContact);
    console.log(this.valueProductSupplied);

    const postData = {
      productSupplied: this.valueProductSupplied,
      contact: this.valueContact,
      address: this.valueAddress,
      name: this.valueName
    };

    if (this.supplierId) {
      this.putSupplier(this.supplierId, postData);
    } else {
      this.postSupplier(postData);
    }

    this.valueProductSupplied = '';
    this.valueContact = '';
    this.valueAddress = '';
    this.valueName = '';


    setTimeout(() => {
      this.router.navigate(['/stockTable']);
    }, 1000);
  }

  postSupplier(postData: any): void {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.http.post(this.apiUrl, postData, { headers })
      .subscribe(
        response => {
          console.log('Post request successful:', response);
          this.router.navigate(['/stockTable']);
        },
        error => {
          console.error('Error making post request:', error);
        }
      );
  }

  putSupplier(supplierId: number, postData: any): void {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.http.put(this.apiUrl + "/" + supplierId, postData, { headers })
      .subscribe(
        response => {
          console.log('Put request successful:', response);
          this.router.navigate(['/stockTable']);
        },
        error => {
          console.error('Error making put request:', error);
        }
      );
  }
}
