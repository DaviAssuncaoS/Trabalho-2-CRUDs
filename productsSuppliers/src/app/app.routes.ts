import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WelcomeComponent } from './pages/welcome/welcome.component';
import { ProductsComponent } from './pages/products/products.component';
import { SuppliersComponent } from './pages/suppliers/suppliers.component';
import { TableComponent } from './pages/table/table.component';
import { StockTableComponent } from './pages/stock-table/stock-table.component';

export const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/welcome' },
  { path: 'welcome', component: WelcomeComponent},
  { path: 'products', component: ProductsComponent},
  { path: 'suppliers', component: SuppliersComponent},
  { path: 'table', component: TableComponent },
  { path: 'products/:productId', component: ProductsComponent },
  { path: 'stockTable', component: StockTableComponent },
  { path: 'suppliers/:supplierId', component: SuppliersComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}